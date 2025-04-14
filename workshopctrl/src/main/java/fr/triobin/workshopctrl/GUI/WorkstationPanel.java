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

        workshopPanel.add(workstationSelector);
        
        return workshopPanel;
    }
}
