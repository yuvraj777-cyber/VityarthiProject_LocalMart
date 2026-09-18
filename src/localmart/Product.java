package localmart;

public class Product {

    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int productId,
                   String name,
                   String category,
                   double price,
                   int quantity) {

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable(int requestedQuantity) {

        return requestedQuantity > 0
                && requestedQuantity <= quantity;
    }

    public void reduceQuantity(int requestedQuantity) {

        quantity = quantity - requestedQuantity;
    }

    public void displayProduct() {

        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: ₹" + price);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("-----------------------------");
    }
}