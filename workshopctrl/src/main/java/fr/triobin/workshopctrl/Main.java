package fr.triobin.workshopctrl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.triobin.workshopctrl.GUI.SelectFrame;

public class Main {
        public static ArrayList<Workshop> workshops = new ArrayList<Workshop>();
        public static Workshop workshop;

        public static void main(String[] args) {
                final GsonBuilder builder = new GsonBuilder();
                final Gson gson = builder.create();
                try {
                        File myObj = new File("./filename.json");
                        if (myObj.createNewFile()) {
                                System.out.println("File created: " + myObj.getName());
                                try {
                                        workshops.add(new Workshop("Workshop 1"));
                                        FileWriter myWriter = new FileWriter("./filename.json");
                                        myWriter.write(gson.toJson(workshops));
                                        myWriter.close();
                                        System.out.println("Successfully wrote to the file.");
                                } catch (IOException e) {
                                        System.out.println("An error occurred.");
                                        e.printStackTrace();
                                }
                        } else {
                                System.out.println("File already exists.");
                                workshops = new ArrayList<Workshop>(
                                                List.of(gson.fromJson(new FileReader("./filename.json"),
                                                                Workshop[].class)));
                        }
                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
                SelectFrame.run();
        }

        public static void fillWorkshop(Workshop workshop) {
                // Create workstations
                Workstation workstation1 = new Workstation("Workstation 1", "W1", new Position(0, 0),
                                new ArrayList<>());
                Workstation workstation2 = new Workstation("Workstation 2", "W2", new Position(1, 0),
                                new ArrayList<>());
                Workstation workstation3 = new Workstation("Workstation 3", "W3", new Position(2, 0),
                                new ArrayList<>());

                // Create products
                Product product1 = new Product("Product 1", "P1", new OPList(new ArrayList<>()));
                Product product2 = new Product("Product 2", "P2", new OPList(new ArrayList<>()));
                Product product3 = new Product("Product 3", "P3", new OPList(new ArrayList<>()));

                // Create operators
                Operator operator1 = new Operator("Operator 1", "Name1", "Surname1", new ArrayList<>(),
                                Operator.OperatorStatus.AVAILABLE);
                Operator operator2 = new Operator("Operator 2", "Name2", "Surname2", new ArrayList<>(),
                                Operator.OperatorStatus.AVAILABLE);
                Operator operator3 = new Operator("Operator 3", "Name3", "Surname3", new ArrayList<>(),
                                Operator.OperatorStatus.AVAILABLE);

                // Create goals
                Goal goal1 = new GeneralGoal(product1, 10);

                // Add workstations, products, operators and goals to the workshop
                workshop.add(workstation1);
                workshop.add(workstation2);
                workshop.add(workstation3);

                workshop.add(product1);
                workshop.add(product2);
                workshop.add(product3);

                workshop.add(operator1);
                workshop.add(operator2);
                workshop.add(operator3);

                workshop.add(goal1);
        }
}