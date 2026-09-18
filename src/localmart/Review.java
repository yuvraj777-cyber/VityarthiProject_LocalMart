package localmart;

public class Review {

    private int reviewId;
    private Customer customer;
    private Shop shop;
    private int rating;
    private String comment;

    public Review(int reviewId,
                  Customer customer,
                  Shop shop,
                  int rating,
                  String comment) {

        this.reviewId = reviewId;
        this.customer = customer;
        this.shop = shop;
        this.rating = rating;
        this.comment = comment;
    }

    public int getReviewId() {
        return reviewId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Shop getShop() {
        return shop;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void displayReview() {

        System.out.println("\n-----------------------------");

        System.out.println(
                "Review ID: " + reviewId
        );

        System.out.println(
                "Customer: " + customer.getName()
        );

        System.out.println(
                "Shop: " + shop.getShopName()
        );

        System.out.println(
                "Rating: " + rating + "/5"
        );

        System.out.println(
                "Comment: " + comment
        );

        System.out.println(
                "-----------------------------"
        );
    }
}