package localmart;

public class Admin extends User {

    public Admin(int userId,
                 String name,
                 String phone,
                 String email) {

        super(userId, name, phone, email);
    }

    @Override
    public void displayUser() {

        System.out.println("Admin ID: " + userId);
        System.out.println("Admin Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}