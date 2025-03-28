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
}
