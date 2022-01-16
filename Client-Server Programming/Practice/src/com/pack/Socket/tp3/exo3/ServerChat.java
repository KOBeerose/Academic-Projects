package com.pack.Socket.tp3.exo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerChat {
    static ArrayList<Socket> Clients= new ArrayList<Socket>();
    static int n=0;
    public static void main(String[] args) throws IOException {
        try (ServerSocket se = new ServerSocket(6666)) {
            while (true) {
                Socket s = se.accept();
                Clients.add(s);
                n += 1;
                Thread chat = new Thread(new Runnable() {
                    public void run() {
                        System.out.println("The Client Number: " + n + " is connected to the server");
                        try {
                            BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
                            PrintWriter out = new PrintWriter(s.getOutputStream());
                            out.println("\nClient " + n + " is accepted!");
                            out.flush();
                            String str;
                            String id = "Client " + n + " : ";
                            String message;
                            try {
                                while (true) {
                                    str = b.readLine();
                                    message = id + str;
                                    for (Socket so : Clients) {
                                        if (so != s) {
                                            PrintWriter o = new PrintWriter(so.getOutputStream());
                                            o.println(message);
                                            o.flush();
                                        }
                                    }
                                }
                            } finally {
                                s.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                chat.start();
            }
        }
    }
}