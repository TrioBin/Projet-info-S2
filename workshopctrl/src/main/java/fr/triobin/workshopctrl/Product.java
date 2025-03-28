package fr.triobin.workshopctrl;

public class Product {
    private String productCode;
    private String dProduct;
    private OPList operations;

    public Product(String productCode, String dProduct, OPList operations) {
        this.productCode = productCode;
        this.dProduct = dProduct;
        this.operations = operations;
    }

    public void print() {
        System.out.println("Product: " + productCode + " Description: " + dProduct);
        operations.print();
    }
    
    public void modifier(OPList operation) {
        this.operations = operation;
    }

    public void remove(){
        operations.removeOperation(0);
    }
}
