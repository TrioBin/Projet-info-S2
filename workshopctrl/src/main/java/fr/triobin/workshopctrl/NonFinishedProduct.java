package fr.triobin.workshopctrl;

public class NonFinishedProduct {
    private Product product;
    private Integer id;
    private ProductStatus status;

    public NonFinishedProduct(Product product, Integer id) {
        this.product = product;
        this.id = id;
        this.status = ProductStatus.FREE;
    }

    public enum ProductStatus {
        FREE, USED
    }
}
