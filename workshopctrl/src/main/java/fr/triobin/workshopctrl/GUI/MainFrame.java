package fr.triobin.workshopctrl.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import fr.triobin.workshopctrl.Workshop;

public class MainFrame {

    public static void run(String workshopName) {
        Workshop workshop = new Workshop(workshopName);
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

        JPanel workshopPanel = WorkshopPanel.generate(workshop);

        JPanel workstationPanel = new JPanel();

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
