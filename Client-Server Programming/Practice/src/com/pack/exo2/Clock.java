package com.pack.exo2;

import javax.swing.*;
import java.awt.*;

public class Clock extends JLabel{
    // to Complete
    public static void main(String[] args) {
        DynamicClock clock = new DynamicClock();
        JFrame frame = new JFrame("Graphic Clock");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        clock.start();
        frame.add(clock.TimeLabel);
        frame.setVisible(true);
    }

}
