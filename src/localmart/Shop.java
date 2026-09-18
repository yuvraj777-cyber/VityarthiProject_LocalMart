package localmart;

import java.util.ArrayList;

public class Shop {

    private int shopId;
    private String shopName;
    private String category;
    private String address;
    private double rating;

    private ShopOwner owner;

    private ArrayList<Product> products;
    private ArrayList<Service> services;
    private ArrayList<Review> reviews;

    public Shop(int shopId,
                String shopName,
                String category,
                String address,
                ShopOwner owner) {

        this.shopId = shopId;
        this.shopName = shopName;
        this.category = category;
        this.address = address;
        this.owner = owner;

        rating = 0.0;

        products = new ArrayList<>();
        services = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    // ==========================================
    // GETTERS
    // ==========================================

    public int getShopId() {
        return shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getCategory() {
        return category;
    }

    public String getAddress() {
        return address;
    }

    public double getRating() {
        return rating;
    }

    public ShopOwner getOwner() {
        return owner;
    }

    public int getReviewCount() {
        return reviews.size();
    }

    // ==========================================
    // PRODUCT METHODS
    // ==========================================

    public void addProduct(Product product) {

        products.add(product);

        System.out.println(
                "Product added successfully."
        );
    }

    public Product findProductById(int productId) {

        for (Product product : products) {

            if (product.getProductId() == productId) {

                return product;
            }
        }

        return null;
    }

    public void displayProducts() {

        System.out.println(
                "\nProducts of " + shopName
        );

        System.out.println(
                "============================"
        );

        if (products.isEmpty()) {

            System.out.println(
                    "No products available."
            );

            return;
        }

        for (Product product : products) {

            product.displayProduct();
        }
    }

    // ==========================================
    // SERVICE METHODS
    // ==========================================

    public void addService(Service service) {

        services.add(service);

        System.out.println(
                "Service added successfully."
        );
    }

    public Service findServiceById(int serviceId) {

        for (Service service : services) {

            if (service.getServiceId() == serviceId) {

                return service;
            }
        }

        return null;
    }

    public void displayServices() {

        System.out.println(
                "\nServices of " + shopName
        );

        System.out.println(
                "============================"
        );

        if (services.isEmpty()) {

            System.out.println(
                    "No services available."
            );

            return;
        }

        for (Service service : services) {

            service.displayService();
        }
    }

    // ==========================================
    // REVIEW METHODS
    // ==========================================

    public void addReview(Review review) {

        if (review == null) {

            System.out.println(
                    "Invalid review."
            );

            return;
        }

        reviews.add(review);

        calculateRating();

        System.out.println(
                "Review added successfully."
        );
    }

    public boolean hasCustomerReviewed(
            Customer customer) {

        for (Review review : reviews) {

            if (review.getCustomer() == customer) {

                return true;
            }
        }

        return false;
    }

    private void calculateRating() {

        if (reviews.isEmpty()) {

            rating = 0.0;

            return;
        }

        int totalRating = 0;

        for (Review review : reviews) {

            totalRating =
                    totalRating + review.getRating();
        }

        rating =
                (double) totalRating / reviews.size();
    }

    public void displayReviews() {

        System.out.println(
                "\nReviews for " + shopName
        );

        System.out.println(
                "============================"
        );

        if (reviews.isEmpty()) {

            System.out.println(
                    "No reviews available."
            );

            return;
        }

        for (Review review : reviews) {

            review.displayReview();
        }

        System.out.println(
                "Average Rating: "
                        + rating
                        + "/5"
        );
    }

    // ==========================================
    // DISPLAY SHOP
    // ==========================================

    public void displayShop() {

        System.out.println(
                "\n============================"
        );

        System.out.println(
                "Shop ID: " + shopId
        );

        System.out.println(
                "Shop Name: " + shopName
        );

        System.out.println(
                "Category: " + category
        );

        System.out.println(
                "Address: " + address
        );

        System.out.println(
                "Rating: " + rating + "/5"
        );

        System.out.println(
                "Owner: " + owner.getName()
        );

        System.out.println(
                "============================"
        );
    }
}