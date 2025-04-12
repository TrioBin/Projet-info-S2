package fr.triobin.workshopctrl.Commands;

import java.util.ArrayList;
import java.util.Scanner;

import fr.triobin.workshopctrl.OPList;
import fr.triobin.workshopctrl.Operation;
import fr.triobin.workshopctrl.Product;
import fr.triobin.workshopctrl.Workshop;

public class AddProduct {
    public static void run(Scanner scanner, Workshop workshop) {
        System.out.println("Adding a product : ");
        System.out.println("Enter the product code : ");
        String productCode = scanner.nextLine();
        System.out.println("Enter the product description : ");
        String dProduct = scanner.nextLine();
    }
}
