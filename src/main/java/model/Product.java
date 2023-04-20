package model;

public class Product {
    private String Product = null;
    private int quantity = 0;
    private int price = 0;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return Product;
    }
}
