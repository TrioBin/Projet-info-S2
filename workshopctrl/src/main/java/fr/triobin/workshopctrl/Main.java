package fr.triobin.workshopctrl;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Machine machine1 = new Machine(new RefMachine("M1"), "Machine 1", new Position(1, 1), new Cost(1),
                new ArrayList<Operation>(), Machine.MachineStatus.AVAILABLE);
        Machine machine2 = new Machine(new RefMachine("M2"), "Machine 2", new Position(2, 2), new Cost(2),
                new ArrayList<Operation>(), Machine.MachineStatus.AVAILABLE);
        Machine machine3 = new Machine(new RefMachine("M3"), "Machine 3", new Position(3, 3), new Cost(3),
                new ArrayList<Operation>(), Machine.MachineStatus.AVAILABLE);

        Operation operation1 = new Operation("OP1", machine1, new Time(1, 0, 0));
        Operation operation2 = new Operation("OP2", machine2, new Time(0, 1, 0));
        Operation operation3 = new Operation("OP3", machine3, new Time(0, 0, 1));

        OPList operations = new OPList(new ArrayList<Operation>());
        operations.addOperation(operation1);
        operations.addOperation(operation2);
        operations.addOperation(operation3);

        Product product = new Product("P1", "Product 1", operations);

        Workshop workshop = new Workshop("Workshop 1");

        ArrayList<Machine> machines = new ArrayList<Machine>();
        machines.add(machine1);
        machines.add(machine2);
        machines.add(machine3);

        Workstation workstation = new Workstation("WS1", "Workstation 1", new Position(1, 1), machines);
        workshop.add(workstation);

        workshop.add(product);

        workshop.add(new GeneralGoal(product, 10));

        workshop.print();

        workshop.getNextGoal().print();
        workshop.getNextGoal().print();
        workshop.getNextGoal().print();
        workshop.getNextGoal().print();
        workshop.getNextGoal().print();
        workshop.getNextGoal().print();

        workshop.print();
    }
}