package fr.triobin.workshopctrl.Commands;

import java.util.Scanner;

import fr.triobin.workshopctrl.Workshop;

public class Add {
    public static void run(Scanner scanner, Workshop workshop) {
        System.out.println("What type of object do you want to print ?");
        System.out.println(1 + ". Workstation");
        System.out.println(2 + ". Goal");
        System.out.println(3 + ". Product");
        System.out.println(4 + ". Operator");

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter a number between 0 and 4 : ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 4) {
                    validInput = true;
                    switch (choice) {
                        case 1:
                            System.out.println("Adding a workstation : ");
                            AddWorkstation.run(scanner, workshop);
                            break;

                        case 2:
                            System.out.println("Adding a goal : ");
                            AddGoal.run(scanner, workshop);
                            break;

                        case 3:
                            System.out.println("Adding a product : ");
                            AddProduct.run(scanner, workshop);
                            break;

                        default:
                            break;
                    }
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
            }
        }
    }
}
