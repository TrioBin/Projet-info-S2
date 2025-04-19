package fr.triobin.workshopctrl.GUI;

import java.awt.BorderLayout;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.triobin.workshopctrl.Main;
import fr.triobin.workshopctrl.Workshop;
import javafx.stage.WindowEvent;
import java.awt.event.WindowAdapter;

public class CreateWorkstation {
    public static void run() {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        JFrame f = new JFrame("Select Workshop");
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
            try {
                FileWriter myWriter = new FileWriter("./filename.json");
                myWriter.write(gson.toJson(Main.workshops));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }
            // Open the new workshop
            MainFrame.run(newWorkshop);
            f.dispose(); // Close the create workshop frame
        });
        workshopPanel.add(createWorkshopButton, BorderLayout.CENTER);

        f.getContentPane().add(workshopPanel, BorderLayout.CENTER);
        f.setVisible(true);
    }
}
