package com.pack.Socket.tp3.exo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",2058);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println("Server response: " + in.readLine());
        client.close();
    }
}
