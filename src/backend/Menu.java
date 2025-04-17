package backend;
import java.util.ArrayList;
import java.util.List;


public class Menu {
    private List<Plat> plats;

    public Menu() {
        this.plats = new ArrayList<>();
    }

    public void ajouterPlat(Plat plat) {
        plats.add(plat);
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void afficherMenu() {
        System.out.println("Menu:");
        for (Plat plat : plats) {
            System.out.println(plat);
        }
    }

    public Plat trouverPlatParNom(String nom) {
        for (Plat plat : plats) {
            if (plat.getNom().equalsIgnoreCase(nom)) {
                return plat;
            }
        }
        return null; // Si le plat n'est pas trouvé
    }
}