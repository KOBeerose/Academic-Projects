package com.pack.Socket.tp3.exo2;

import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(8000)) {
            BufferedReader b = new BufferedReader(new FileReader("Practice/src/com/pack/Socket/tp3/exo2/Content.html"));
            while (true) {
                Socket s = listener.accept();
                String body = b.readLine();
                Thread cl = new Thread(new Runnable() {
                    public void run() {
                        PrintWriter out = null;
                        try {
                            out = new PrintWriter(s.getOutputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        assert out != null;
                        out.println("HTTP/1.0 200 OK\n\n" + body);
                        out.flush();
                    }
                });
                cl.start();
            }
        }

    }
}