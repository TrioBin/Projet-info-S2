package fr.triobin.workshopctrl;

import java.util.ArrayList;

public class Machine {
    private RefMachine refMachine;
    private String dmachine;
    private Position position;
    private Cost c;
    private ArrayList<Operation> operations;
    private MachineStatus status;

    public Machine(RefMachine refMachine, String dmachine, Position position, Cost c, ArrayList<Operation> operations, MachineStatus status) {
        this.refMachine = refMachine;
        this.dmachine = dmachine;
        this.position = position;
        this.c = c;
        this.operations = operations;
        this.status = status;
    }

    public enum MachineStatus {
        AVAILABLE,
        USED,
        MAINTENANCE
    }
}
