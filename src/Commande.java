import java.util.ArrayList;
import java.util.List;

public class Commande {
    private List<Plat> plats;

    public Commande() {
        this.plats = new ArrayList<>();
    }

    public void ajouterPlat(Plat plat) {
        plats.add(plat);
    }

    public double calculerTotal() {
        double total = 0;
        for (Plat plat : plats) {
            total += plat.getPrix();
        }
        return total;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("Commande:\n");
        for (Plat plat : plats) {
            details.append(plat.toString()).append("\n");
        }
        details.append("Total: ").append(calculerTotal()).append("€");
        return details.toString();
    }
}