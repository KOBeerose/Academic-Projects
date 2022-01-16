package com.pack.RMI.sol;


public interface Promotion extends java.rmi.Remote 
{
	Etudiant ajouter_un_etudiant(int numero_etudiant, String nom, String prenom) 
		throws java.rmi.RemoteException;
	Etudiant rechercher_un_etudiant(int numero_etudiant)
		throws java.rmi.RemoteException;

	double calculer_moyenne_de_la_promotion() 
		throws java.rmi.RemoteException;

}


