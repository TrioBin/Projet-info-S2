package fr.triobin.workshopctrl.GUI;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.triobin.workshopctrl.Workshop;

public class WorkshopPanel {
    public static JPanel generate(Workshop workshop) {
        JPanel workshopPanel = new JPanel();
        workshopPanel.setLayout(new BorderLayout());
        workshopPanel.setBorder(BorderFactory.createTitledBorder("Workshop"));
        
        // Create a label to display the workshop name
        JLabel workshopLabel = new JLabel("Workshop Name: " + workshop.getDesignation());
        workshopLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Create a button to add a new workshop
        JButton addWorkshopButton = new JButton("Add Workshop");
        
        // Add components to the panel
        workshopPanel.add(workshopLabel, BorderLayout.NORTH);
        workshopPanel.add(addWorkshopButton, BorderLayout.SOUTH);
        
        return workshopPanel;
    }
}
