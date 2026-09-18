package localmart;

public class Order {

    private int orderId;
    private Customer customer;
    private Shop shop;
    private Product product;
    private int quantity;
    private double totalAmount;
    private String status;

    public Order(int orderId,
                 Customer customer,
                 Shop shop,
                 Product product,
                 int quantity) {

        this.orderId = orderId;
        this.customer = customer;
        this.shop = shop;
        this.product = product;
        this.quantity = quantity;

        if (product.isAvailable(quantity)) {

            totalAmount = product.getPrice() * quantity;

            product.reduceQuantity(quantity);

            status = "PLACED";

        } else {

            totalAmount = 0;
            status = "FAILED - INSUFFICIENT STOCK";
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Shop getShop() {
        return shop;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    // ==========================================
    // UPDATE ORDER STATUS
    // ==========================================

    public boolean updateStatus(String newStatus) {

        // PLACED -> CONFIRMED
        if (status.equals("PLACED")
                && newStatus.equals("CONFIRMED")) {

            status = newStatus;
            return true;
        }

        // CONFIRMED -> PROCESSING
        if (status.equals("CONFIRMED")
                && newStatus.equals("PROCESSING")) {

            status = newStatus;
            return true;
        }

        // PROCESSING -> COMPLETED
        if (status.equals("PROCESSING")
                && newStatus.equals("COMPLETED")) {

            status = newStatus;
            return true;
        }

        return false;
    }

    public void displayOrder() {

        System.out.println(
                "\n============================"
        );

        System.out.println(
                "Order ID: " + orderId
        );

        System.out.println(
                "Customer: " + customer.getName()
        );

        System.out.println(
                "Shop: " + shop.getShopName()
        );

        System.out.println(
                "Product: " + product.getName()
        );

        System.out.println(
                "Quantity: " + quantity
        );

        System.out.println(
                "Total Amount: ₹" + totalAmount
        );

        System.out.println(
                "Status: " + status
        );

        System.out.println(
                "============================"
        );
    }
}