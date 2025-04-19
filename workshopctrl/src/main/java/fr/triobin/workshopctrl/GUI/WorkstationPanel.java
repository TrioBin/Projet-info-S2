package fr.triobin.workshopctrl.GUI;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.triobin.workshopctrl.Main;
import fr.triobin.workshopctrl.Workshop;
import fr.triobin.workshopctrl.Workstation;

import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.JButton;

public class WorkstationPanel {
    public static JPanel generate() {
        JPanel workshopPanel = new JPanel();
        workshopPanel.setLayout(new BorderLayout());
        workshopPanel.setBorder(BorderFactory.createTitledBorder("Workshop"));
        
        // Create a select list that open the selected workshop with ComboBox
        JComboBox<String> workstationSelector = new JComboBox<>();
        for (Workstation workstation : Main.workshop.getWorkstations()) {
            workstationSelector.addItem(workstation.getRefWorkstation());
        }

        // Add a Create button to create a new workstation that open the workstation creation frame
        JButton createWorkstationButton = new JButton("Create a new workstation");
        createWorkstationButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        createWorkstationButton.addActionListener(e -> {
            // Open the selected workstation creation frame
            System.out.println("Creating a new workstation");
            CreateWorkstation.run();
        });
        
        workshopPanel.add(createWorkstationButton, BorderLayout.SOUTH);
        workshopPanel.add(workstationSelector, BorderLayout.NORTH);
        
        return workshopPanel;
    }
}
