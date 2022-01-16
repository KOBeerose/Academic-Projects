package com.pack.RMI.sol;

public interface Etudiant extends java.rmi.Remote 
{
	String nom() throws java.rmi.RemoteException;
	String prenom() throws java.rmi.RemoteException;
	int numero_etudiant() throws java.rmi.RemoteException;

	String afficher_liste_des_epreuves() throws java.rmi.RemoteException;
	void ajouter_une_epreuve(Epreuve e) throws java.rmi.RemoteException;
	double calculer_la_moyenne() throws java.rmi.RemoteException;
	
}


