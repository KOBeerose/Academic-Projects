package com.pack.RMI.sol;


import java.net.*;


//
// Cette classe permet d'obtenir les nom DNS soit de facon qualifie
// soit de facon non qualifie ; et ce qq soit la forme avec laquelle
// la classe est instanciee
//
public class MyHostName 
{

	
	private String hostname;
	private String domain = ".univ-brest.fr";


	public MyHostName(String hote)  
	{
		if(hote.equals(""))
			this.local();
		else	if (hote.indexOf(".")==-1)
				hostname = hote;
			else	hostname = hote.substring(0,hote.indexOf("."));
	}


	public MyHostName() 
	{
		this.local();
	}


	private void local() 
	{
		try 
		{
			InetAddress machine = InetAddress.getLocalHost();
                	hostname = machine.getHostName();
		
			if (hostname.indexOf(".")!=-1)
				hostname = hostname.substring(0,hostname.indexOf("."));

		}
		catch(UnknownHostException e) 
		{
		System.out.println ("MyHostName exception: " + e.getMessage ());
		e.printStackTrace ();
		}
	}


	public String nonQualifiedHost() 
	{
		return (hostname);
	}


	public String QualifiedHost() 
	{
		return (hostname);
	}

}


