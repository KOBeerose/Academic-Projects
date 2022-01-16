package com.pack.Socket.tp3.exo1;


import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.io.IOException;
import java.net.ServerSocket;


public class Server {
    ArrayList<String> proverbs = new ArrayList<String>();
    Random r=new Random();
    public Server() throws IOException {
    }
    public void setProverbs(String s){
        this.proverbs.add(s);
    }
    public String getProverb(){
        int j=r.nextInt(this.proverbs.size());
        return(this.proverbs.get(j));
    }
    public static void main(String[] args) throws IOException {
        Server s=new Server();
        s.setProverbs("Poverty is slavery");
        s.setProverbs("A hungry man is not a free man");
        s.setProverbs("Health is better than wealth");
        s.setProverbs("An old man who dies, a library burns");
        s.setProverbs("It is with the water of the body that one draws that of the well.");
        s.setProverbs("As high as a bird flies, it eventually lands");
        s.setProverbs("When a tree falls, you hear it; when the forest grows, not a sound.");
        s.setProverbs("Where water rules, the earth must obey");
        s.setProverbs("Peace is not an empty word, it is behavior");
        s.setProverbs("If you want to go fast, go alone, but if you want to go far, then you have to go together");
        try (ServerSocket listener = new ServerSocket(2058)) {
            while (true) {
                Socket so = listener.accept();
                System.out.println("new client connected");
                PrintWriter o = new PrintWriter(so.getOutputStream());
                o.println(s.getProverb());
                o.flush();
                System.out.println("write");
            }
        }
    }
}