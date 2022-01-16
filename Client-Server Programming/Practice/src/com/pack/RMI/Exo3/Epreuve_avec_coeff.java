package com.pack.RMI.Exo3;

public class Epreuve_avec_coeff implements Epreuve {
    public double mark;
    public String examName;
    public double coefficient;
    public Epreuve_avec_coeff (double mark, String examName, double coefficient) {
        this.mark=mark;
        this.examName=examName;
        this.coefficient=coefficient;
    }
    public String afficher() {
        return examName + " Exam: " + mark;
    }
    public double mark() {
        return mark*coefficient;
    }
}