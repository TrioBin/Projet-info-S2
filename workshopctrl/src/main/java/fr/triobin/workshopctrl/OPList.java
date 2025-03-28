package fr.triobin.workshopctrl;

public class OPList {
    private Operation[] operations;

    public OPList(Operation[] operations) {
        this.operations = operations;
    }
    public void print(){
        for (Operation operation : operations) {
            operation.print();
        }
    }
}
