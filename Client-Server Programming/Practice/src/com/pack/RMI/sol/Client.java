package com.pack.RMI.sol;

import java.rmi.*;


public class Client 
{


	static String portRmiregistry;


	public Client (String Machine)
	{
		System.setProperty("java.security.policy","file:./src/com/pack/RMI/sol/java.policy.txt");
		try
		{
			String nomService = "//" + Machine + ":" + portRmiregistry + "/PromotionServeur";
			System.out.println (" Connexion au service : " + nomService);
			Promotion obj = (Promotion) Naming.lookup (nomService);


			Etudiant Etudiant1 = obj.ajouter_un_etudiant(1, "albert", "le gall");
			Etudiant Etudiant2 = obj.ajouter_un_etudiant(2, "michel", "le gall");
			Etudiant Etudiant3 = obj.ajouter_un_etudiant(3, "franck", "le gall");

			Etudiant2.ajouter_une_epreuve(new Epreuve_avec_coeff(10, "math", 1));
			Etudiant3.ajouter_une_epreuve(new Epreuve_avec_coeff(6, "physique", 0.5));
			Etudiant3.ajouter_une_epreuve(new Epreuve_avec_coeff(14, "math", 0.5));

			System.out.println(Etudiant1.afficher_liste_des_epreuves());	
			System.out.println(Etudiant2.afficher_liste_des_epreuves());	
			System.out.println(Etudiant3.afficher_liste_des_epreuves());	

			System.out.println("moy Etudiant1 = " + Etudiant1.calculer_la_moyenne());
			System.out.println("moy Etudiant2 = " + Etudiant2.calculer_la_moyenne());
			System.out.println("moy Etudiant3 = " + Etudiant3.calculer_la_moyenne());
			System.out.println("moy promo = " + obj.calculer_moyenne_de_la_promotion());
			
		}

		catch (Exception e)
		{
			System.out.println ("Client.java exception: " + e.getMessage ());
			e.printStackTrace ();
		}


	}



	//   Methode principale
	//
	public static void main (String args[])
	{

		portRmiregistry="1099";

		MyHostName machine = new MyHostName("localhost");
		new Client (machine.QualifiedHost());
	}


}
