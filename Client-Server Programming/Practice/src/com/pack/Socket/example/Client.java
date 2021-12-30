package com.pack.Socket.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);
        System.out.print("Server Name : ");
        host = keyb.next();
        System.out.print("Port Name : ");
        port = keyb.nextInt();
        try {
            InetAddress adr = InetAddress.getByName(host);
            Socket socket = new Socket(adr, port);
            ObjectOutputStream output =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input =
                    new ObjectInputStream(socket.getInputStream());
            output.writeObject(new String("First Socket"));
            String chaine = (String) input.readObject();
            System.out.println(" Recieved from : " + chaine);
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }
}