package com.pack.RMI.Exo3;

import java.rmi.server.UnicastRemoteObject;

public class EtudiantImpl extends UnicastRemoteObject implements Etudiant {
    private final String _firstName;
    private final String _lastName;
    private final int _studentId;
    private final Epreuve [] liste;
    int nb;
    public EtudiantImpl(int studentId, String firstName, String lastName) throws java.rmi.RemoteException {
        _studentId=studentId;
        _firstName=firstName;
        _lastName=lastName;
        liste = new Epreuve[10];
        nb=0;
    }
    public String get_Name() throws java.rmi.RemoteException {
        return _firstName.concat(" "+_lastName);
    }
    public String afficher_liste_des_epreuves() throws java.rmi.RemoteException {
        StringBuilder Result= new StringBuilder();
        Result.append("Student ").append(_studentId).append(" : ").append(_firstName).append(" ").append(_lastName);
        for (int i=0; i<nb; i++)
            Result.append(liste[i].afficher());
        return Result.toString();
    }
    public void ajouter_une_epreuve(Epreuve e) throws java.rmi.RemoteException {
        liste[nb]=e;
        nb++;
    }
    public double calculer_la_moyenne() throws java.rmi.RemoteException {
        double mean = 0.0;
        double nbm =0.0;
        for (int i=0; i<nb; i++) {
            mean=mean+liste[i].mark();
            nbm=nbm+1.0;
        }
        if (nb>0)
            return mean/nbm;
        else return 0;
    }
}
