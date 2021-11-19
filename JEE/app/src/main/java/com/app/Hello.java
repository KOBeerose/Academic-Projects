package com.app;

import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
public class Hello {
    private String hello = "Hello, il est : ";

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getMessage() {
        return hello + " " + new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
