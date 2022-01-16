package com.pack.RMI.Exo3;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public class PromotionServeur extends UnicastRemoteObject implements Promotion {
    private final Etudiant [] studentsList;
    int nb;
    public Etudiant ajouter_un_etudiant(int StudentId, String firstName, String lastName) throws java.rmi.RemoteException {
        EtudiantImpl e = new EtudiantImpl(StudentId, firstName, lastName);
        studentsList[nb] = e;
        nb++;
        return e;
    }
    public double calculer_moyenne_de_la_promotion() throws java.rmi.RemoteException {
        double mean = 0.0;
        double nbm = 0.0;
        for (int i=0; i<nb; i++) {
            mean= mean + studentsList[i].calculer_la_moyenne();
            nbm= nbm+1.0;
        }
        if (nb>0)
            return mean/nbm;
        else return 0;
    }
    public PromotionServeur() throws RemoteException {
        nb=0;
        studentsList = new Etudiant[50];
    }

    public static void main(String[] args) throws IOException {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            PromotionServeur MonServeur = new PromotionServeur();
            Naming.rebind("rmi://localhost/PromotionServeur", MonServeur);
            System.out.println(" PromotionServeur bound in registry at the url ");
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed.\n" + e);
        }
    }
}