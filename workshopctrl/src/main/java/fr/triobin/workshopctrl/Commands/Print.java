package fr.triobin.workshopctrl.Commands;

import java.util.Scanner;

import fr.triobin.workshopctrl.Workshop;

public class Print {
    public static void run(Scanner scanner, Workshop workshop) {
        System.out.println("What type of object do you want to print ?");
        int i = 0;
        int possibilities[] = new int[5];
        System.out.println(0 + ". Workshop");
        possibilities[0] = 1;
        if (workshop.getWorkstations().size() > 0) {
            i++;
            System.out.println(i + ". Workstation");
            possibilities[i] = 2;
        }
        if (workshop.getGoals().size() > 0) {
            i++;
            System.out.println(i + ". Goal");
            possibilities[i] = 3;
        }
        if (workshop.getProducts().size() > 0) {
            i++;
            System.out.println(i + ". Product");
            possibilities[i] = 4;
        }
        if (workshop.getOperators().size() > 0) {
            i++;
            System.out.println(i + ". Operator");
            possibilities[i] = 5;
        }

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter a number between 0 and " + i + " : ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 0 && choice <= i) {
                    validInput = true;
                    switch (possibilities[choice]) {
                        case 1:
                            workshop.print();
                            break;

                        case 2:
                            System.out.println("Workstations : ");
                            for (int j = 0; j < workshop.getWorkstations().size(); j++) {
                                workshop.getWorkstations().get(j).print();
                            }
                            break;

                        case 3:
                            System.out.println("Goals : ");
                            for (int j = 0; j < workshop.getGoals().size(); j++) {
                                workshop.getGoals().get(j).print();
                            }
                            break;

                        case 4:
                            System.out.println("Products : ");
                            for (int j = 0; j < workshop.getProducts().size(); j++) {
                                workshop.getProducts().get(j).print();
                            }
                            break;

                        case 5:
                            System.out.println("Operators : ");
                            for (int j = 0; j < workshop.getOperators().size(); j++) {
                                workshop.getOperators().get(j).print();
                            }
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
