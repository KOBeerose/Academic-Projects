package com.pack.RMI.Exo3;

import java.rmi.*;

public interface Etudiant extends Remote {
    String afficher_liste_des_epreuves() throws RemoteException;
    void ajouter_une_epreuve(Epreuve e) throws RemoteException;
    double calculer_la_moyenne() throws RemoteException;
}
