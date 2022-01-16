package com.pack.RMI.Exo3;

import java.rmi.*;

public class Client {
    public static void main (String[] args) {
        try {
            System.out.println ("Connection to : localhost:1099/PromotionServeur");
            Promotion obj = (Promotion) Naming.lookup ("rmi://localhost/PromotionServeur");
            Etudiant Student1 = obj.ajouter_un_etudiant(1, "Taha", "ELGHABI");
            Etudiant Student2 = obj.ajouter_un_etudiant(2, "Badr-eddine", "EL BATOURI");
            Etudiant Student3 = obj.ajouter_un_etudiant(3, "Mohammed", "70");
            // note de Taha
            Student1.ajouter_une_epreuve(new Epreuve_avec_coeff(18, " Python for Data Science", 4));
            Student1.ajouter_une_epreuve(new Epreuve_avec_coeff(15, " Client Server Programming", 2));
            Student1.ajouter_une_epreuve(new Epreuve_avec_coeff(1, " Time Series", 3));
            // notes de Badr
            Student2.ajouter_une_epreuve(new Epreuve_avec_coeff(11, " Python for Data Science", 4));
            Student2.ajouter_une_epreuve(new Epreuve_avec_coeff(20, " Client Server Programming", 2));
            Student2.ajouter_une_epreuve(new Epreuve_avec_coeff(0.5, " Time Series", 3));
            // notes de 70
            Student3.ajouter_une_epreuve(new Epreuve_avec_coeff(17, " Python for Data Science", 4));
            Student3.ajouter_une_epreuve(new Epreuve_avec_coeff(14, " Client Server Programming", 2));
            Student3.ajouter_une_epreuve(new Epreuve_avec_coeff(9, " Time Series", 3));
            System.out.println(Student1.afficher_liste_des_epreuves());
            System.out.println(Student2.afficher_liste_des_epreuves());
            System.out.println(Student3.afficher_liste_des_epreuves());
            System.out.println("Average mark of "+Student1.get_Name() +" "+ Student1.calculer_la_moyenne());
            System.out.println("Average mark of Student 2 = " + Student2.calculer_la_moyenne());
            System.out.println("Average mark of Student 3 = " + Student3.calculer_la_moyenne());
            System.out.println("Average mark of the Class = " + obj.calculer_moyenne_de_la_promotion());
        }
        catch (Exception e) {
            System.out.println ("Client.java exception: " + e.getMessage ());
            e.printStackTrace ();
        }
    }
}
