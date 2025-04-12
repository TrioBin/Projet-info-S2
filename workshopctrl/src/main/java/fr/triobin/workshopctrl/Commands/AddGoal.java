package fr.triobin.workshopctrl.Commands;

import java.util.Scanner;

import fr.triobin.workshopctrl.GeneralGoal;
import fr.triobin.workshopctrl.Position;
import fr.triobin.workshopctrl.Product;
import fr.triobin.workshopctrl.Workshop;

public class AddGoal {
    public static void run(Scanner scanner, Workshop workshop) {
        // if not product, return
        if (workshop.getProducts().isEmpty()) {
            System.out.println("No product available, please add a product first.");
            return;
        }
        System.out.println("Choose a product : ");
        int i = 1;
        for (var product : workshop.getProducts()) {
            System.out.println(i + ". " + product.getName() + " (" + product.getId() + ")");
            i++;
        }
        boolean validInput = false;
        int productId = -1;
        while (!validInput) {
            System.out.println("Please enter a number between 1 and " + (i - 1) + " : ");
            String input = scanner.nextLine();
            try {
                productId = Integer.parseInt(input);
                if (productId >= 1 && productId <= i - 1) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
            }
        }
        Product product = workshop.getProducts().get(productId - 1);
        System.out.print("Enter the goal quantity : ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()
        workshop.add(new GeneralGoal(product, quantity));
    }
}