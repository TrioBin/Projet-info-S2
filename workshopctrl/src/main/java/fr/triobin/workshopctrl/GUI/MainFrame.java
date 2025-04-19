package fr.triobin.workshopctrl.GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fr.triobin.workshopctrl.Main;
import fr.triobin.workshopctrl.Workshop;

public class MainFrame {

    public static void run(Workshop workshop) {
        Main.workshop = workshop;
        // create a JFrame to hold everything
        JFrame f = new JFrame("TabbedPaneFrame");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                SelectFrame.run();
            }
        });
        f.setSize(800, 500);
        f.setLocation(200, 200);

        JTabbedPane tabby = new JTabbedPane();

        JPanel workshopPanel = WorkshopPanel.generate();

        JPanel workstationPanel = WorkstationPanel.generate();

        JPanel productPanel = new JPanel();

        JPanel operatorPanel = new JPanel();

        tabby.addTab("Workshop", workshopPanel);
        tabby.addTab("Workstation", workstationPanel);
        tabby.addTab("Product", productPanel);
        tabby.addTab("Operator", operatorPanel);

        f.getContentPane().add(tabby);
        f.setVisible(true);
    }
}
