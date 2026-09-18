package localmart;

public class User {

    protected int userId;
    protected String name;
    protected String phone;
    protected String email;

    public User(int userId, String name, String phone, String email) {

        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void displayUser() {

        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}