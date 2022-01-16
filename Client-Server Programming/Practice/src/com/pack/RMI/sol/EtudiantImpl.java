package com.pack.RMI.sol;

import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;


public class EtudiantImpl extends UnicastRemoteObject     
	  implements Etudiant
{

	private String _nom;
	private String _prenom;
	private int _numero;

	private Epreuve []  liste = null;
	int nb;

	public EtudiantImpl(int num, String nom, String prenom) throws java.rmi.RemoteException	
	{
		_numero=num;
		_nom=nom;
		_prenom=prenom;
		liste = new Epreuve[10];
		nb=0;
	}

	public String nom() throws java.rmi.RemoteException
	{
		return _nom;
	}
	public String prenom() throws java.rmi.RemoteException
	{
		return _prenom;
	}
	public int numero_etudiant() throws java.rmi.RemoteException
	{
		return _numero;
	}

	public String afficher_liste_des_epreuves() throws java.rmi.RemoteException
	{
		String Result="";
		Result=Result + "Etudiant " + _numero + " : " + _nom + " " + _prenom;
		for (int i=0; i<nb; i++)
			Result = Result + liste[i].afficher();
		return Result;
	}

	public void ajouter_une_epreuve(Epreuve e) throws java.rmi.RemoteException
	{
		liste[nb]=e;
		nb++;
	}

	public double calculer_la_moyenne() throws java.rmi.RemoteException
	{
		double moy = 0.0;
		double nbm =0.0;

		for (int i=0; i<nb; i++)
			{
			moy=moy+liste[i].note();
			nbm=nbm+1.0;
			}

		if (nb>0)
           		return moy/nbm;
		else	return 0;
	}

	


}
