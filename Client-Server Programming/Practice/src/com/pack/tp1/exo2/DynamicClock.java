package com.pack.tp1.exo2;

import javax.swing.*;
import java.awt.*;

public class DynamicClock extends Thread{
    int[] Temps = {0,0};
    JLabel TimeLabel = new JLabel(Temps[0]+" : "+ Temps[1],JLabel.CENTER);
    public void run()
    {
        TimeLabel.setFont(new Font("",40,40));
        while(true)
        {
            try
            {

                sleep(1000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            Temps[1]= Temps[1]+1;
            if(Temps[1]>59)
            {
                Temps[1]=0;
                Temps[0]= Temps[0]+1;
                if(Temps[0]>59)
                {
                    Temps[0]=0;
                }
            }
            TimeLabel.setText(Temps[0]+" : "+ Temps[1]);
        }
    }
}