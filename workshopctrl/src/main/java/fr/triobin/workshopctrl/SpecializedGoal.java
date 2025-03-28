package fr.triobin.workshopctrl;

public class SpecializedGoal extends Goal {
    private Operation operation;
    private NonFinishedProduct product;

    public SpecializedGoal(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void print() {
        System.out.println("- SpecializedGoal: " + operation.getName());
    }
}
