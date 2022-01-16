package com.pack.RMI.Exo3;

import java.rmi.*;

public interface Promotion extends Remote {
    Etudiant ajouter_un_etudiant(int StudentId, String firstName, String lastName) throws RemoteException;
    double calculer_moyenne_de_la_promotion() throws RemoteException;
}