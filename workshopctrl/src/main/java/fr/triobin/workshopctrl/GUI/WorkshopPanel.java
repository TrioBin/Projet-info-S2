package fr.triobin.workshopctrl.GUI;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.triobin.workshopctrl.Main;

public class WorkshopPanel {
    public static JPanel generate() {
        JPanel workshopPanel = new JPanel();
        workshopPanel.setLayout(new BorderLayout());
        workshopPanel.setBorder(BorderFactory.createTitledBorder("Workshop"));
        
        // Create a label to display the workshop name
        JLabel workshopLabel = new JLabel("Workshop Name: " + Main.workshop.getDesignation());
        workshopLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Add components to the panel
        workshopPanel.add(workshopLabel, BorderLayout.NORTH);
        
        return workshopPanel;
    }
}
