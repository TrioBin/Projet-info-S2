package fr.triobin.workshopctrl.Commands;

import java.util.ArrayList;
import java.util.Scanner;

import fr.triobin.workshopctrl.Position;
import fr.triobin.workshopctrl.Workshop;
import fr.triobin.workshopctrl.Workstation;

public class AddWorkstation {
    public static void run(Scanner scanner, Workshop workshop) {
        System.out.print("Enter the workstation name : ");
        String name = scanner.nextLine();
        System.out.print("Enter the workstation code : ");
        String code = scanner.nextLine();
        System.out.print("Enter the workstation position (x y) : ");
        String position = scanner.nextLine();
        String[] pos = position.split(" ");
        Position p = new Position(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
        Workstation workstation = new Workstation(name, code, p, new ArrayList<>());
        workshop.add(workstation);
    }
}
