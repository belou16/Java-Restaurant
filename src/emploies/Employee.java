package emploies;
public abstract class Employee {
    protected String nom;
    protected String role;


    public Employee (String nom, String role) {
        this.nom = nom;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public String getRole() {
        return role;
    }


}





