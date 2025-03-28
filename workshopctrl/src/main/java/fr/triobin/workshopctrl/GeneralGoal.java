package fr.triobin.workshopctrl;

public class GeneralGoal extends Goal {
    private Product product;
    private int quantity;

    public GeneralGoal(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
