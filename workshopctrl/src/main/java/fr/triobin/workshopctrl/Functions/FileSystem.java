package fr.triobin.workshopctrl.Functions;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.triobin.workshopctrl.Main;

public class FileSystem {
    public static void save() {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        try {
            FileWriter myWriter = new FileWriter("./filename.json");
            myWriter.write(gson.toJson(Main.workshops));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }
}
