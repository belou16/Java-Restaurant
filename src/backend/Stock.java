package backend;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import DB.*;

public class Stock {
    private Map<String, Integer> ingredients;

    public Stock() {
        ingredients = new HashMap<>();
        chargerStock();
    }

    private void chargerStock() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ingredient, quantite FROM stocks")) {
            while (rs.next()) {
                ingredients.put(rs.getString("ingredient"), rs.getInt("quantite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifierIngredient(String ingredient, int quantite) {
        return ingredients.getOrDefault(ingredient, 0) >= quantite;
    }

    public void mettreAJourStock(String ingredient, int quantite) {
        if (verifierIngredient(ingredient, quantite)) {
            ingredients.put(ingredient, ingredients.get(ingredient) - quantite);
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement("UPDATE stocks SET quantite = ? WHERE ingredient = ?")) {
                pstmt.setInt(1, ingredients.get(ingredient));
                pstmt.setString(2, ingredient);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Rupture de stock pour l'ingrédient : " + ingredient);
        }
    }
}