package com.pack.Socket.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String argv[]) {
        int port = 5000;
        Scanner keyb = new Scanner(System.in);
        System.out.print("Listening on Port : ");
        port = keyb.nextInt();

        try {

            ServerSocket serverSocket = new ServerSocket(port);


            Socket socket = serverSocket.accept();

            ObjectOutputStream output =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input =
                    new ObjectInputStream(socket.getInputStream());

            String chaine = (String) input.readObject();
            System.out.println(" recieved : " + chaine);

            System.out.println(" Came from : " + socket.getInetAddress() + ":" + socket.getPort());

            output.writeObject(new String("Well Recieved"));
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }
}