package com.pack.RMI.Exo3;

import java.rmi.*;

public class Client {
    static String portRmiregistry;
    public Client (String Machine) {
        try {
            String nomService = "//" + Machine + ":" + portRmiregistry + "/PromotionServeur";
            System.out.println (" Connexion au service : " + nomService);
            Promotion obj = (Promotion) Naming.lookup (nomService);
            Etudiant Student1 = obj.ajouter_un_etudiant(1, "albert", "le gall");
            Etudiant Student2 = obj.ajouter_un_etudiant(2, "michel", "le gall");
            Etudiant Student3 = obj.ajouter_un_etudiant(3, "franck", "le gall");
            Student1.ajouter_une_epreuve(new Epreuve_avec_coeff(10, "math", 1));
            Student2.ajouter_une_epreuve(new Epreuve_avec_coeff(6, "physique", 0.5));
            Student3.ajouter_une_epreuve(new Epreuve_avec_coeff(14, "math", 0.5));
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

    public static void main (String[] args) {
        portRmiregistry= "1099";
        MyHostName machine = new MyHostName("DESKTOP-LPGN4E3");
        new Client (machine.QualifiedHost());
    }
}
