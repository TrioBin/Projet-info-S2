package fr.triobin.workshopctrl;

import java.util.ArrayList;

public class OPList {
    private ArrayList<Operation> operations;

    public OPList(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public void print() {
        for (Operation operation : operations) {
            operation.print();
        }
    }

    public void modifier(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public void removeOperation(Integer operation) {
        operations.remove(operation);
    }
}
