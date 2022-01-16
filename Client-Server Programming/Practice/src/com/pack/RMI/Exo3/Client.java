package com.pack.RMI.Exo3;

import java.rmi.*;

public class Client {
    public static void main (String[] args) {
        try {
            System.out.println ("Connection to : localhost:1099/PromotionServeur");
            Promotion obj = (Promotion) Naming.lookup ("rmi://localhost/PromotionServeur");
            Etudiant Student1 = obj.ajouter_un_etudiant(1, "Taha", "ELGHABI");
            Etudiant Student2 = obj.ajouter_un_etudiant(2, "Badr", "ELBATOURI");
            Etudiant Student3 = obj.ajouter_un_etudiant(3, "Mohammed", "70");
            Student1.ajouter_une_epreuve(new Epreuve_avec_coeff(18, "Python for Data Science", 1));
            Student2.ajouter_une_epreuve(new Epreuve_avec_coeff(15, "Client Server Programming", 0.5));
            Student3.ajouter_une_epreuve(new Epreuve_avec_coeff(1, "Time Series", 0.5));
            System.out.println(Student1.afficher_liste_des_epreuves());
            System.out.println(Student2.afficher_liste_des_epreuves());
            System.out.println(Student3.afficher_liste_des_epreuves());
            System.out.println("moy Student1 = " + Student1.calculer_la_moyenne());
            System.out.println("moy Student2 = " + Student2.calculer_la_moyenne());
            System.out.println("moy Student3 = " + Student3.calculer_la_moyenne());
            System.out.println("moy promo = " + obj.calculer_moyenne_de_la_promotion());
        }
        catch (Exception e) {
            System.out.println ("Client.java exception: " + e.getMessage ());
            e.printStackTrace ();
        }
    }
}
