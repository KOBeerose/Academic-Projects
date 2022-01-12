package com.pack.Socket.tp3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Server {
    ArrayList<String> msg = new ArrayList<String>();
    Random random = new Random();

    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(5500);
        try {
            while (true) {
                Socket socket = listener.accept();
                System.out.println("New client is connected");
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("HTTP/1.0 200 OK\n\n"
                        + "<HTML><TITLE>My Server</TITLE>This page is sent by my <B>Server </B></HTML>");
                out.flush();
                System.out.println("Writing");
            }
        } finally {
            listener.close();
        }
    }

}
