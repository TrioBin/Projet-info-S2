package fr.triobin.workshopctrl.GUI;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.triobin.workshopctrl.Main;
import fr.triobin.workshopctrl.Workshop;
import fr.triobin.workshopctrl.Functions.FileSystem;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import javax.swing.JTextArea;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateWorkshop {
    public static void run() {
        JFrame f = new JFrame("Create Workshop");
        f.setSize(800, 500);
        f.setLocation(200, 200);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                SelectFrame.run();
            }
        });

        JPanel workshopPanel = new JPanel();
        workshopPanel.setLayout(new BoxLayout(workshopPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment

        JPanel box = new JPanel();
        box.setLayout(new BorderLayout());
        JLabel commentlabel = new JLabel("Workshop Name : ");
        JTextArea commentbox = new JTextArea(1, 20);
        commentbox.setLineWrap(true);
        box.add(commentbox, BorderLayout.CENTER);
        box.add(commentlabel, BorderLayout.WEST);
        workshopPanel.add(box);

        JButton createWorkshopButton = new JButton("Create Workshop");
        JPanel buttonWrapper = new JPanel();
        buttonWrapper.setLayout(new BorderLayout());
        buttonWrapper.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0)); // Add 50px top margin
        buttonWrapper.add(createWorkshopButton, BorderLayout.CENTER);
        workshopPanel.add(buttonWrapper);

        createWorkshopButton.addActionListener(e -> {
            // Create a new workshop with the name from the text input
            String workshopName = commentbox.getText();
            Workshop newWorkshop = new Workshop(workshopName);
            Main.workshops.add(newWorkshop);
            // Save the new workshop to the file
            FileSystem.save();
            // Open the new workshop
            MainFrame.run(newWorkshop);
            f.dispose(); // Close the create workshop frame
        });
        workshopPanel.add(createWorkshopButton, BorderLayout.CENTER);

        f.getContentPane().add(workshopPanel, BorderLayout.CENTER);
        f.setVisible(true);
    }
}
