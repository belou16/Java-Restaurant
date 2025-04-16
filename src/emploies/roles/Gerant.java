package emploies.roles;
import emploies.*;
import backend.*;

public class Gerant extends Employee {
    public Gerant(String nom) {
        super(nom, "Gérant");
    }

    public void gererStock(Stock stock) {
        // Logique pour gérer le stock
    }
}