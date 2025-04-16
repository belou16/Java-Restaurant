import java.util.Scanner;
import backend.*;
import DB.*;
import emploies.*;
import emploies.roles.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Stock stock = new Stock();

        // Ajout de plats au menu
        menu.ajouterPlat(new Plat("Margherita", 8.50, "pizza"));
        menu.ajouterPlat(new Plat("Carbonara", 12.00, "pâtes"));
        menu.ajouterPlat(new Plat("Tiramisu", 5.00, "dessert"));
        menu.ajouterPlat(new Plat("Coca-Cola", 2.50, "boisson"));

        // Affichage du menu
        menu.afficherMenu();

        // Création d'une commande
        Commande commande = new Commande();
        String choix;

        do {
            System.out.print("Entrez le nom du plat à ajouter à la commande (ou 'fin' pour terminer) : ");
            choix = scanner.nextLine();
            boolean platTrouve = false;

            for (Plat plat : menu.getPlats()) {
                if (plat.getNom().equalsIgnoreCase(choix)) {
                    // Vérification du stock avant d'ajouter le plat à la commande
                    if (stock.verifierIngredient(plat.getNom(), 1)) {
                        commande.ajouterPlat(plat);
                        stock.mettreAJourStock(plat.getNom(), 1);
                        platTrouve = true;
                        System.out.println(plat.getNom() + " ajouté à la commande.");
                    } else {
                        System.out.println("Impossible d'ajouter " + plat.getNom() + " : rupture de stock.");
                    }
                    break;
                }
            }

            if (!platTrouve && !choix.equalsIgnoreCase("fin")) {
                System.out.println("Plat non trouvé. Veuillez réessayer.");
            }

        } while (!choix.equalsIgnoreCase("fin"));

        // Affichage de la commande
        System.out.println(commande);
        scanner.close();
    }
}