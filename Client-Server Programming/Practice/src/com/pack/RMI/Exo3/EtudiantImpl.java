package com.pack.RMI.Exo3;

import java.rmi.server.UnicastRemoteObject;

public class EtudiantImpl extends UnicastRemoteObject implements Etudiant {
    private final String _nom;
    private final String _prenom;
    private final int _numero;
    private final Epreuve [] liste;
    int nb;
    public EtudiantImpl(int num, String nom, String prenom) throws java.rmi.RemoteException {
        _numero=num;
        _nom=nom;
        _prenom=prenom;
        liste = new Epreuve[10];
        nb=0;
    }
    public String nom() throws java.rmi.RemoteException {
        return _nom;
    }
    public String prenom() throws java.rmi.RemoteException {
        return _prenom;
    }
    public int numero_etudiant() throws java.rmi.RemoteException {
        return _numero;
    }
    public String afficher_liste_des_epreuves() throws java.rmi.RemoteException {
        StringBuilder Result= new StringBuilder();
        Result.append("Etudiant ").append(_numero).append(" : ").append(_nom).append(" ").append(_prenom);
        for (int i=0; i<nb; i++)
            Result.append(liste[i].afficher());
        return Result.toString();
    }
    public void ajouter_une_epreuve(Epreuve e) throws java.rmi.RemoteException {
        liste[nb]=e;
        nb++;
    }
    public double calculer_la_moyenne() throws java.rmi.RemoteException {
        double moy = 0.0;
        double nbm =0.0;
        for (int i=0; i<nb; i++) {
            moy=moy+liste[i].note();
            nbm=nbm+1.0;
        }
        if (nb>0)
            return moy/nbm;
        else return 0;
    }
}
