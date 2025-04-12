package fr.triobin.workshopctrl.GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectFrame {
    public static void run() {
        JFrame f = new JFrame("Select Workshop");
        f.setSize(800, 500);
        f.setLocation(200, 200);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        JPanel workshopPanel = new JPanel();
        
        String[] workshopNames = {"Workshop 1", "Workshop 2", "Workshop 3"};
        // Create select list that open the selected workshop
        JLabel workshopLabel = new JLabel("Select a workshop:");
        workshopLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        workshopPanel.add(workshopLabel, BorderLayout.NORTH);

        for (String workshopName : workshopNames) {
            JButton workshopButton = new JButton(workshopName);
            workshopButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            workshopButton.addActionListener(e -> {
                // Open the selected workshop
                System.out.println("Opening " + workshopName);
                // Here you can add code to open the selected workshop
            });
            workshopPanel.add(workshopButton, BorderLayout.CENTER);
        }

        f.getContentPane().add(workshopPanel, BorderLayout.CENTER);
        f.setVisible(true);
    }
}
