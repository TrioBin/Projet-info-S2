package fr.triobin.workshopctrl;

import java.util.ArrayList;

public class GeneralGoal extends Goal {
    private Product product;
    private int quantity;

    public GeneralGoal(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void print() {
        System.out.println("GeneralGoal: " + product.getName() + " " + quantity);
    }

    public ArrayList<Operation> getOperations() {
        ArrayList<Operation> operations = new ArrayList<>();
        for (int i = 0; i < this.quantity; i++) {
            operations.addAll(product.getOperations());
        }
        return operations;
    }
}
