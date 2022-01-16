package com.pack.RMI.Exo3;

public class Epreuve_avec_coeff implements Epreuve {
    public double note;
    public String nom_epreuve;
    public double coefficient;
    public Epreuve_avec_coeff (double note, String nom_epreuve, double coefficient) {
        this.note=note;
        this.nom_epreuve=nom_epreuve;
        this.coefficient=coefficient;
    }
    public String afficher() {
        return "Epreuve " + nom_epreuve + ": " + note;
    }
    public double note() {
        return note*coefficient;
    }
}