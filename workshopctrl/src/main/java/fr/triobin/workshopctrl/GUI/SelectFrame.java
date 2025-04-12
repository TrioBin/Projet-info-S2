package fr.triobin.workshopctrl.GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.triobin.workshopctrl.Workshop;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SelectFrame {
    public static void run(Workshop[] workshops) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        JFrame f = new JFrame("Select Workshop");
        f.setSize(800, 500);
        f.setLocation(200, 200);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        try {
            File myObj = new File("./filename.json");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                try {
                    FileWriter myWriter = new FileWriter("./filename.json");
                    myWriter.write(gson.toJson(workshops));
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        JPanel workshopPanel = new JPanel();
        // Create select list that open the selected workshop
        JLabel workshopLabel = new JLabel("Select a workshop:");
        workshopLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        workshopPanel.add(workshopLabel, BorderLayout.NORTH);

        for (Workshop workshop : workshops) {
            String workshopName = workshop.getDesignation();
            JButton workshopButton = new JButton(workshopName);
            workshopButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            workshopButton.addActionListener(e -> {
                // Open the selected workshop
                System.out.println("Opening " + workshopName);
                MainFrame.run(workshopName);
                f.dispose(); // Close the select frame
            });
            workshopPanel.add(workshopButton, BorderLayout.CENTER);
        }

        // Add a button to create a new workshop that open the workshop creation frame
        JButton newWorkshopButton = new JButton("Create a new workshop");
        newWorkshopButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        newWorkshopButton.addActionListener(e -> {
            // Open the workshop creation frame
            System.out.println("Creating a new workshop");
            // Here you can add code to open the workshop creation frame
        });
        workshopPanel.add(newWorkshopButton, BorderLayout.SOUTH);

        f.getContentPane().add(workshopPanel, BorderLayout.CENTER);
        f.setVisible(true);
    }
}
