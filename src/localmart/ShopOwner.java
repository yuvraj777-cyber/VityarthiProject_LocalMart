package localmart;

public class ShopOwner extends User {

    public ShopOwner(int userId,
                     String name,
                     String phone,
                     String email) {

        super(userId, name, phone, email);
    }

    @Override
    public void displayUser() {

        System.out.println("Shop Owner ID: " + userId);
        System.out.println("Shop Owner Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}