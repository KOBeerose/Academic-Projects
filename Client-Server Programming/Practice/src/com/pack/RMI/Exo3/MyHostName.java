package com.pack.RMI.Exo3;

import java.net.*;

public class MyHostName {

    private String hostname;

    public MyHostName(String hote) {
        if(hote.equals(""))
            this.local();
        else	if (!hote.contains("."))
            hostname = hote;
        else	hostname = hote.substring(0,hote.indexOf("."));
    }

    public MyHostName() {
        this.local();
    }

    private void local() {
        try {
            InetAddress machine = InetAddress.getLocalHost();
            hostname = machine.getHostName();

            if (hostname.contains("."))
                hostname = hostname.substring(0,hostname.indexOf("."));

        }
        catch(UnknownHostException e) {
            System.out.println ("MyHostName exception: " + e.getMessage ());
            e.printStackTrace ();
        }
    }

    public String nonQualifiedHost() {
        return (hostname);
    }

    public String QualifiedHost() {
        String domain = ".inpt.ma";
        return (hostname);
    }
}

