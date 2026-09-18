package localmart;

public class Customer extends User {

    public Customer(int userId,
                    String name,
                    String phone,
                    String email) {

        super(userId, name, phone, email);
    }

    @Override
    public void displayUser() {

        System.out.println("Customer ID: " + userId);
        System.out.println("Customer Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}