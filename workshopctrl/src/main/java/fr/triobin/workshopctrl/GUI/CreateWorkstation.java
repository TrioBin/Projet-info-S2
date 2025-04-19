package fr.triobin.workshopctrl.GUI;

import java.awt.BorderLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.triobin.workshopctrl.Main;
import fr.triobin.workshopctrl.Position;
import fr.triobin.workshopctrl.Workstation;
import javafx.stage.WindowEvent;
import java.awt.event.WindowAdapter;

import fr.triobin.workshopctrl.Functions.FileSystem;

public class CreateWorkstation {
    public static void run() {
        JFrame f = new JFrame("Create Workstation");
        f.setSize(800, 500);
        f.setLocation(200, 200);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                SelectFrame.run();
            }
        });

        JPanel workstationPanel = new JPanel();
        workstationPanel.setLayout(new BoxLayout(workstationPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment

        JPanel nameBox = new JPanel();
        nameBox.setLayout(new BorderLayout());
        JLabel nameLabel = new JLabel("Workstation Name : ");
        JTextArea nameText = new JTextArea(1, 20);
        nameText.setLineWrap(true);
        nameBox.add(nameText, BorderLayout.CENTER);
        nameBox.add(nameLabel, BorderLayout.WEST);
        workstationPanel.add(nameBox);

        JPanel refBox = new JPanel();
        refBox.setLayout(new BorderLayout());
        JLabel refLabel = new JLabel("Workstation Ref : ");
        JTextArea refText = new JTextArea(1, 20);
        refText.setLineWrap(true);
        refBox.add(refText, BorderLayout.CENTER);
        refBox.add(refLabel, BorderLayout.WEST);
        workstationPanel.add(refBox);

        JPanel positionBox = new JPanel();
        positionBox.setLayout(new BorderLayout());
        JLabel positionLabel = new JLabel("Workstation Position : ");
        JTextArea positionText = new JTextArea(1, 20);
        positionText.setLineWrap(true);
        positionBox.add(positionText, BorderLayout.CENTER);
        positionBox.add(positionLabel, BorderLayout.WEST);
        workstationPanel.add(positionBox);

        JButton createWorkstationButton = new JButton("Create Workstation");
        JPanel buttonWrapper = new JPanel();
        buttonWrapper.setLayout(new BorderLayout());
        buttonWrapper.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0)); // Add 50px top margin
        buttonWrapper.add(createWorkstationButton, BorderLayout.CENTER);
        workstationPanel.add(buttonWrapper);

        createWorkstationButton.addActionListener(e -> {
            // Create a new workshop with the name from the text input
            String workstationName = nameText.getText();
            String workstationRef = refText.getText();
            String workstationPosition = positionText.getText();
            Position position = new Position(Integer.parseInt(workstationPosition.split(",")[0].trim()), Integer.parseInt(workstationPosition.split(",")[1].trim()));

            Workstation newWorkstation = new Workstation(workstationRef, workstationName, position, new ArrayList<>());
            Main.workshop.add(newWorkstation); // Add the new workshop to the list
            // Save the new workshop to the file
            FileSystem.save();
            f.dispose(); // Close the create workshop frame
        });
        workstationPanel.add(createWorkstationButton, BorderLayout.CENTER);

        f.getContentPane().add(workstationPanel, BorderLayout.CENTER);
        f.setVisible(true);
    }
}
