package com.demo;

import javax.annotation.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean

public class Bonjour {
    private String bonjour = "Bonjour, il est : ";

    public String getBonjour() {
        return bonjour;
    }

    public void setBonjour(String bonjour) {
        this.bonjour = bonjour;
    }

    public String getMessage() {
        return bonjour + " " + new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
