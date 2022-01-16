package com.pack.RMI.Exo3;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public class PromotionServeur extends UnicastRemoteObject implements Promotion {
    private final Etudiant [] liste;
    int nb;
    public Etudiant ajouter_un_etudiant(int numero_etudiant, String nom, String prenom) throws java.rmi.RemoteException {
        EtudiantImpl e = new EtudiantImpl(numero_etudiant, nom, prenom);
        liste[nb]=e;
        nb++;
        return e;
    }
    public Etudiant rechercher_un_etudiant(int numero_etudiant) throws java.rmi.RemoteException {
        for (int i=0; i<nb; i++)
            if (liste[i].numero_etudiant() == numero_etudiant)
                return liste[i];
        throw new RemoteException("Etudiant absent");
    }
    public double calculer_moyenne_de_la_promotion() throws java.rmi.RemoteException {
        double moy = 0.0;
        double nbm =0.0;
        for (int i=0; i<nb; i++) {
            moy=moy+liste[i].calculer_la_moyenne();
            nbm=nbm+1.0;
        }
        if (nb>0)
            return moy/nbm;
        else return 0;
    }
    public PromotionServeur() throws RemoteException {
        nb=0;
        liste = new Etudiant[10];
    }

    public static void main(String[] args) throws IOException {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            PromotionServeur MonServeur = new PromotionServeur();
            MyHostName machine = new MyHostName();
            String nomService = "//" + machine.QualifiedHost() + ":" + "1099" + "/PromotionServeur";
            Naming.rebind(nomService, MonServeur);
            System.out.println("PromotionServeur enregistre : " + nomService);
        }
        catch (RemoteException e) {
            System.out.println("PromotionServeur err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}