package emploies.roles;
import emploies.*;
import backend.*;

class Cuisinier extends Employee {
    public Cuisinier(String nom) {
        super(nom, "Cuisinier");
    }

    public void preparerPlat(Plat plat) {
        // Logique pour préparer un plat
    }
}