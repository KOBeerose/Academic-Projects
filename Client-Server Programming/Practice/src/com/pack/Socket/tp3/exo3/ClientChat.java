package com.pack.Socket.tp3.exo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost",6666);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Thread receive = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){
                        try {
                            msg=in.readLine();
                            if(msg!=null)
                                System.out.println(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            Thread send = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){
                        System.out.println("You : ");
                        Scanner sc = new Scanner(System.in);
                        msg = sc.nextLine();
                        out.println(msg);
                        out.flush();
                    }
                }
            });
            receive.start();
            send.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
