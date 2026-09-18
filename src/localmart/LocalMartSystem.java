package localmart;

import java.util.ArrayList;
import java.util.Scanner;

public class LocalMartSystem {

    private Scanner scanner;

    private ArrayList<Customer> customers;
    private ArrayList<ShopOwner> shopOwners;
    private ArrayList<Admin> admins;
    private ArrayList<Shop> shops;
    private ArrayList<Order> orders;
    private ArrayList<ServiceRequest> serviceRequests;
    private ArrayList<Appointment> appointments;

    private int nextUserId = 1;
    private int nextShopId = 1;
    private int nextOrderId = 1;
    private int nextRequestId = 1;
    private int nextAppointmentId = 1;
    private int nextReviewId = 1;

    public LocalMartSystem() {

        scanner = new Scanner(System.in);

        customers = new ArrayList<>();
        shopOwners = new ArrayList<>();
        admins = new ArrayList<>();
        shops = new ArrayList<>();
        orders = new ArrayList<>();
        serviceRequests = new ArrayList<>();
        appointments = new ArrayList<>();

        // Default admin
        Admin admin = new Admin(
                nextUserId++,
                "System Admin",
                "9999999999",
                "admin@localmart.com"
        );

        admins.add(admin);
    }

    // =========================================================
    // START
    // =========================================================

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("          LOCALMART SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Customer");
            System.out.println("2. Shop Owner");
            System.out.println("3. Admin");
            System.out.println("4. Exit");
            System.out.println("======================================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    customerLogin();
                    break;

                case 2:
                    shopOwnerLogin();
                    break;

                case 3:
                    adminLogin();
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using LocalMart.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // CUSTOMER LOGIN
    // =========================================================

    private void customerLogin() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          CUSTOMER");
        System.out.println("======================================");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Back");

        int choice = readInt("Enter your choice: ");

        switch (choice) {

            case 1:

                if (customers.isEmpty()) {
                    System.out.println("No customers registered.");
                    return;
                }

                int customerId =
                        readInt("Enter Customer ID: ");

                Customer customer =
                        findCustomerById(customerId);

                if (customer == null) {
                    System.out.println("Customer not found.");
                    return;
                }

                System.out.println(
                        "Welcome, " + customer.getName() + "!"
                );

                customerMenu(customer);
                break;

            case 2:
                registerCustomer();
                break;

            case 3:
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    // =========================================================
    // REGISTER CUSTOMER
    // =========================================================

    private void registerCustomer() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       CUSTOMER REGISTRATION");
        System.out.println("======================================");

        String name =
                readNonEmptyString("Enter name: ");

        String phone =
                readNonEmptyString("Enter phone: ");

        String email =
                readNonEmptyString("Enter email: ");

        Customer customer =
                new Customer(
                        nextUserId++,
                        name,
                        phone,
                        email
                );

        customers.add(customer);

        System.out.println();
        System.out.println("Customer registered successfully.");
        System.out.println(
                "Your Customer ID: "
                        + customer.getUserId()
        );
    }

    // =========================================================
    // CUSTOMER MENU
    // =========================================================

    private void customerMenu(Customer customer) {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("          CUSTOMER MENU");
            System.out.println("======================================");
            System.out.println("1. View My Profile");
            System.out.println("2. View All Shops");
            System.out.println("3. Search Shop");
            System.out.println("4. Browse Shop Products");
            System.out.println("5. Browse Shop Services");
            System.out.println("6. Place Product Order");
            System.out.println("7. Request Service");
            System.out.println("8. View My Orders");
            System.out.println("9. View My Service Requests");
            System.out.println("10. View My Appointments");
            System.out.println("11. Add Review");
            System.out.println("12. View Shop Reviews");
            System.out.println("13. Logout");
            System.out.println("======================================");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    customer.displayUser();
                    break;

                case 2:
                    displayAllShops();
                    break;

                case 3:
                    searchShop();
                    break;

                case 4:
                    browseShopProducts();
                    break;

                case 5:
                    browseShopServices();
                    break;

                case 6:
                    placeOrder(customer);
                    break;

                case 7:
                    requestService(customer);
                    break;

                case 8:
                    displayCustomerOrders(customer);
                    break;

                case 9:
                    displayCustomerServiceRequests(customer);
                    break;

                case 10:
                    displayCustomerAppointments(customer);
                    break;

                case 11:
                    addReview(customer);
                    break;

                case 12:
                    viewShopReviews();
                    break;

                case 13:
                    running = false;
                    System.out.println("Customer logged out.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // SHOP OWNER LOGIN
    // =========================================================

    private void shopOwnerLogin() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          SHOP OWNER");
        System.out.println("======================================");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Back");

        int choice =
                readInt("Enter your choice: ");

        switch (choice) {

            case 1:

                if (shopOwners.isEmpty()) {
                    System.out.println(
                            "No shop owners registered."
                    );
                    return;
                }

                int ownerId =
                        readInt("Enter Shop Owner ID: ");

                ShopOwner owner =
                        findShopOwnerById(ownerId);

                if (owner == null) {
                    System.out.println(
                            "Shop owner not found."
                    );
                    return;
                }

                System.out.println(
                        "Welcome, " + owner.getName() + "!"
                );

                shopOwnerMenu(owner);
                break;

            case 2:
                registerShopOwner();
                break;

            case 3:
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    // =========================================================
    // REGISTER SHOP OWNER
    // =========================================================

    private void registerShopOwner() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       SHOP OWNER REGISTRATION");
        System.out.println("======================================");

        String name =
                readNonEmptyString("Enter owner name: ");

        String phone =
                readNonEmptyString("Enter phone: ");

        String email =
                readNonEmptyString("Enter email: ");

        ShopOwner owner =
                new ShopOwner(
                        nextUserId++,
                        name,
                        phone,
                        email
                );

        shopOwners.add(owner);

        System.out.println();
        System.out.println("Enter shop details.");

        String shopName =
                readNonEmptyString("Shop name: ");

        String category =
                readNonEmptyString("Shop category: ");

        String address =
                readNonEmptyString("Shop address: ");

        Shop shop =
                new Shop(
                        nextShopId++,
                        shopName,
                        category,
                        address,
                        owner
                );

        shops.add(shop);

        System.out.println();
        System.out.println(
                "Shop owner registered successfully."
        );

        System.out.println(
                "Your Owner ID: "
                        + owner.getUserId()
        );

        System.out.println(
                "Your Shop ID: "
                        + shop.getShopId()
        );
    }

    // =========================================================
    // SHOP OWNER MENU
    // =========================================================

    private void shopOwnerMenu(ShopOwner owner) {

        Shop shop =
                findShopByOwner(owner);

        if (shop == null) {

            System.out.println(
                    "No shop is associated with this owner."
            );

            return;
        }

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("          SHOP OWNER MENU");
            System.out.println("======================================");
            System.out.println(
                    "Shop: " + shop.getShopName()
            );
            System.out.println("--------------------------------------");

            System.out.println("1. View Shop");
            System.out.println("2. Add Product");
            System.out.println("3. View Products");
            System.out.println("4. Add Service");
            System.out.println("5. View Services");
            System.out.println("6. View Orders");
            System.out.println("7. Update Order Status");
            System.out.println("8. View Service Requests");
            System.out.println("9. Update Service Request");
            System.out.println("10. View Appointments");
            System.out.println("11. Update Appointment");
            System.out.println("12. View Reviews");
            System.out.println("13. Logout");

            System.out.println("======================================");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    shop.displayShop();
                    break;

                case 2:
                    addProduct(shop);
                    break;

                case 3:
                    shop.displayProducts();
                    break;

                case 4:
                    addService(shop);
                    break;

                case 5:
                    shop.displayServices();
                    break;

                case 6:
                    displayShopOrders(shop);
                    break;

                case 7:
                    updateOrderStatus(shop);
                    break;

                case 8:
                    displayShopServiceRequests(shop);
                    break;

                case 9:
                    updateServiceRequest(shop);
                    break;

                case 10:
                    displayShopAppointments(shop);
                    break;

                case 11:
                    updateAppointment(shop);
                    break;

                case 12:
                    shop.displayReviews();
                    break;

                case 13:
                    running = false;
                    System.out.println(
                            "Shop owner logged out."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =========================================================
    // ADD PRODUCT
    // =========================================================

    private void addProduct(Shop shop) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("             ADD PRODUCT");
        System.out.println("======================================");

        int productId =
                readInt("Enter Product ID: ");

        if (shop.findProductById(productId) != null) {

            System.out.println(
                    "Product ID already exists."
            );

            return;
        }

        String name =
                readNonEmptyString(
                        "Enter product name: "
                );

        String category =
                readNonEmptyString(
                        "Enter category: "
                );

        double price =
                readPositiveDouble(
                        "Enter price: "
                );

        int quantity =
                readPositiveInt(
                        "Enter quantity: "
                );

        Product product =
                new Product(
                        productId,
                        name,
                        category,
                        price,
                        quantity
                );

        shop.addProduct(product);
    }
    

    // =========================================================
    // VIEW PRODUCTS
    // =========================================================

    private void viewProducts(Shop shop) {

        shop.displayProducts();
    }

    // =========================================================
    // ADD SERVICE
    // =========================================================

    private void addService(Shop shop) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("             ADD SERVICE");
        System.out.println("======================================");

        int serviceId =
                readInt("Enter Service ID: ");

        if (shop.findServiceById(serviceId) != null) {

            System.out.println(
                    "Service ID already exists."
            );

            return;
        }

        String serviceName =
                readNonEmptyString(
                        "Enter service name: "
                );

        String description =
                readNonEmptyString(
                        "Enter description: "
                );

        double startingPrice =
                readPositiveDouble(
                        "Enter starting price: "
                );

        Service service =
                new Service(
                        serviceId,
                        serviceName,
                        description,
                        startingPrice
                );

        shop.addService(service);
    }

    // =========================================================
    // DISPLAY ALL SHOPS
    // =========================================================

    private void displayAllShops() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("             ALL SHOPS");
        System.out.println("======================================");

        if (shops.isEmpty()) {

            System.out.println(
                    "No shops available."
            );

            return;
        }

        for (Shop shop : shops) {
            shop.displayShop();
        }
    }

    // =========================================================
    // SEARCH SHOP
    // =========================================================

    private void searchShop() {

        String keyword =
                readNonEmptyString(
                        "Enter shop name or category: "
                );

        boolean found = false;

        for (Shop shop : shops) {

            if (shop.getShopName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())
                    ||
                    shop.getCategory()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                shop.displayShop();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No matching shop found."
            );
        }
    }

    // =========================================================
    // BROWSE PRODUCTS
    // =========================================================

    private void browseShopProducts() {

        int shopId =
                readInt("Enter Shop ID: ");

        Shop shop =
                findShopById(shopId);

        if (shop == null) {

            System.out.println(
                    "Shop not found."
            );

            return;
        }

        shop.displayProducts();
    }

    // =========================================================
    // BROWSE SERVICES
    // =========================================================

    private void browseShopServices() {

        int shopId =
                readInt("Enter Shop ID: ");

        Shop shop =
                findShopById(shopId);

        if (shop == null) {

            System.out.println(
                    "Shop not found."
            );

            return;
        }

        shop.displayServices();
    }

    // =========================================================
    // PLACE ORDER
    // =========================================================

    private void placeOrder(Customer customer) {

        int shopId =
                readInt("Enter Shop ID: ");

        Shop shop =
                findShopById(shopId);

        if (shop == null) {

            System.out.println(
                    "Shop not found."
            );

            return;
        }

        shop.displayProducts();

        int productId =
                readInt("Enter Product ID: ");

        Product product =
                shop.findProductById(productId);

        if (product == null) {

            System.out.println(
                    "Product not found."
            );

            return;
        }

        int quantity =
                readPositiveInt(
                        "Enter quantity: "
                );

        if (!product.isAvailable(quantity)) {

            System.out.println(
                    "Insufficient stock."
            );

            return;
        }

        Order order =
                new Order(
                        nextOrderId++,
                        customer,
                        shop,
                        product,
                        quantity
                );

        orders.add(order);

        System.out.println(
                "Order created successfully."
        );

        order.displayOrder();
    }

    // =========================================================
    // REQUEST SERVICE
    // =========================================================

    private void requestService(Customer customer) {

        int shopId =
                readInt("Enter Shop ID: ");

        Shop shop =
                findShopById(shopId);

        if (shop == null) {

            System.out.println(
                    "Shop not found."
            );

            return;
        }

        shop.displayServices();

        int serviceId =
                readInt("Enter Service ID: ");

        Service service =
                shop.findServiceById(serviceId);

        if (service == null) {

            System.out.println(
                    "Service not found."
            );

            return;
        }

        String requirement =
                readNonEmptyString(
                        "Describe your requirement: "
                );

        String preferredDate =
                readNonEmptyString(
                        "Enter preferred date: "
                );

        String contactMethod =
                readNonEmptyString(
                        "Preferred contact method: "
                );

        ServiceRequest request =
                new ServiceRequest(
                        nextRequestId++,
                        customer,
                        shop,
                        service,
                        requirement,
                        preferredDate,
                        contactMethod
                );

        serviceRequests.add(request);

        System.out.println();
        System.out.println(
                "Service request submitted successfully."
        );

        request.displayRequest();
    }

    // =========================================================
    // CUSTOMER ORDERS
    // =========================================================

    private void displayCustomerOrders(
            Customer customer) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("             MY ORDERS");
        System.out.println("======================================");

        boolean found = false;

        for (Order order : orders) {

            if (order.getCustomer() == customer) {

                order.displayOrder();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No orders found."
            );
        }
    }

    // =========================================================
    // SHOP ORDERS
    // =========================================================

    private void displayShopOrders(Shop shop) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("           SHOP ORDERS");
        System.out.println("======================================");

        boolean found = false;

        for (Order order : orders) {

            if (order.getShop() == shop) {

                order.displayOrder();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No orders found."
            );
        }
    }

    // =========================================================
    // UPDATE ORDER
    // =========================================================

    private void updateOrderStatus(Shop shop) {

        displayShopOrders(shop);

        int orderId =
                readInt("Enter Order ID: ");

        Order order =
                findOrderById(orderId);

        if (order == null
                || order.getShop() != shop) {

            System.out.println(
                    "Order not found."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Current Status: "
                        + order.getStatus()
        );

        System.out.println("1. CONFIRMED");
        System.out.println("2. PROCESSING");
        System.out.println("3. COMPLETED");

        int choice =
                readInt("Enter new status: ");

        String newStatus;

        switch (choice) {

            case 1:
                newStatus = "CONFIRMED";
                break;

            case 2:
                newStatus = "PROCESSING";
                break;

            case 3:
                newStatus = "COMPLETED";
                break;

            default:
                System.out.println(
                        "Invalid choice."
                );
                return;
        }

        if (order.updateStatus(newStatus)) {

            System.out.println(
                    "Order status updated successfully."
            );

        } else {

            System.out.println(
                    "Invalid status transition."
            );
        }
    }

    // =========================================================
    // CUSTOMER SERVICE REQUESTS
    // =========================================================

    private void displayCustomerServiceRequests(
            Customer customer) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       MY SERVICE REQUESTS");
        System.out.println("======================================");

        boolean found = false;

        for (ServiceRequest request
                : serviceRequests) {

            if (request.getCustomer() == customer) {

                request.displayRequest();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No service requests found."
            );
        }
    }

    // =========================================================
    // SHOP SERVICE REQUESTS
    // =========================================================

    private void displayShopServiceRequests(
            Shop shop) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       SHOP SERVICE REQUESTS");
        System.out.println("======================================");

        boolean found = false;

        for (ServiceRequest request
                : serviceRequests) {

            if (request.getShop() == shop) {

                request.displayRequest();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No service requests found."
            );
        }
    }

    // =========================================================
    // UPDATE SERVICE REQUEST
    // =========================================================

    private void updateServiceRequest(Shop shop) {

        displayShopServiceRequests(shop);

        int requestId =
                readInt("Enter Request ID: ");

        ServiceRequest request =
                findServiceRequestById(requestId);

        if (request == null
                || request.getShop() != shop) {

            System.out.println(
                    "Service request not found."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Current Status: "
                        + request.getStatus()
        );

        System.out.println("1. CONTACTED");
        System.out.println("2. APPOINTMENT_SCHEDULED");
        System.out.println("3. SITE_VISIT");
        System.out.println("4. QUOTATION");
        System.out.println("5. ACCEPTED");
        System.out.println("6. IN_PROGRESS");
        System.out.println("7. COMPLETED");

        int choice =
                readInt("Enter new status: ");

        String newStatus;

        switch (choice) {

            case 1:
                newStatus = "CONTACTED";
                break;

            case 2:
                newStatus = "APPOINTMENT_SCHEDULED";
                break;

            case 3:
                newStatus = "SITE_VISIT";
                break;

            case 4:
                newStatus = "QUOTATION";
                break;

            case 5:
                newStatus = "ACCEPTED";
                break;

            case 6:
                newStatus = "IN_PROGRESS";
                break;

            case 7:
                newStatus = "COMPLETED";
                break;

            default:
                System.out.println(
                        "Invalid choice."
                );
                return;
        }

        if (request.updateStatus(newStatus)) {

            System.out.println(
                    "Service request updated successfully."
            );

            if (newStatus.equals(
                    "APPOINTMENT_SCHEDULED")) {

                createAppointment(request);
            }

        } else {

            System.out.println(
                    "Invalid status transition."
            );
        }
    }

    // =========================================================
    // CREATE APPOINTMENT
    // =========================================================

    private void createAppointment(
            ServiceRequest request) {

        // Prevent duplicate appointment
        for (Appointment appointment
                : appointments) {

            if (appointment.getServiceRequest()
                    == request) {

                System.out.println(
                        "Appointment already exists."
                );

                return;
            }
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("          CREATE APPOINTMENT");
        System.out.println("======================================");

        System.out.println(
                "Customer: "
                        + request.getCustomer().getName()
        );

        System.out.println(
                "Shop: "
                        + request.getShop().getShopName()
        );

        System.out.println(
                "Service: "
                        + request.getService().getServiceName()
        );

        System.out.println(
                "Preferred Date: "
                        + request.getPreferredDate()
        );

        String date =
                request.getPreferredDate();

        String time =
                readNonEmptyString(
                        "Enter appointment time: "
                );

        Appointment appointment =
                new Appointment(
                        nextAppointmentId++,
                        request.getCustomer(),
                        request.getShop(),
                        request.getService(),
                        request,
                        date,
                        time
                );

        appointments.add(appointment);

        System.out.println();
        System.out.println(
                "Appointment created successfully."
        );

        appointment.displayAppointment();
    }

    // =========================================================
    // CUSTOMER APPOINTMENTS
    // =========================================================

    private void displayCustomerAppointments(
            Customer customer) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          MY APPOINTMENTS");
        System.out.println("======================================");

        boolean found = false;

        for (Appointment appointment
                : appointments) {

            if (appointment.getCustomer()
                    == customer) {

                appointment.displayAppointment();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No appointments found."
            );
        }
    }

    // =========================================================
    // SHOP APPOINTMENTS
    // =========================================================

    private void displayShopAppointments(
            Shop shop) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("         SHOP APPOINTMENTS");
        System.out.println("======================================");

        boolean found = false;

        for (Appointment appointment
                : appointments) {

            if (appointment.getShop() == shop) {

                appointment.displayAppointment();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No appointments found."
            );
        }
    }

    // =========================================================
    // UPDATE APPOINTMENT
    // =========================================================

    private void updateAppointment(Shop shop) {

        displayShopAppointments(shop);

        int appointmentId =
                readInt("Enter Appointment ID: ");

        Appointment appointment =
                findAppointmentById(
                        appointmentId
                );

        if (appointment == null
                || appointment.getShop() != shop) {

            System.out.println(
                    "Appointment not found."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Current Status: "
                        + appointment.getStatus()
        );

        System.out.println("1. COMPLETED");
        System.out.println("2. CANCELLED");

        int choice =
                readInt("Enter new status: ");

        String newStatus;

        if (choice == 1) {

            newStatus = "COMPLETED";

        } else if (choice == 2) {

            newStatus = "CANCELLED";

        } else {

            System.out.println(
                    "Invalid choice."
            );

            return;
        }

        if (appointment.updateStatus(newStatus)) {

            System.out.println(
                    "Appointment status updated successfully."
            );

        } else {

            System.out.println(
                    "Invalid appointment status transition."
            );
        }
    }

    // =========================================================
    // ADD REVIEW
    // =========================================================

    private void addReview(Customer customer) {

        int shopId =
                readInt("Enter Shop ID: ");

        Shop shop =
                findShopById(shopId);

        if (shop == null) {

            System.out.println(
                    "Shop not found."
            );

            return;
        }

        if (shop.hasCustomerReviewed(customer)) {

            System.out.println(
                    "You have already reviewed this shop."
            );

            return;
        }

        boolean eligible = false;

        // Completed order
        for (Order order : orders) {

            if (order.getCustomer() == customer
                    && order.getShop() == shop
                    && order.getStatus()
                    .equals("COMPLETED")) {

                eligible = true;
                break;
            }
        }

        // Completed service
        if (!eligible) {

            for (ServiceRequest request
                    : serviceRequests) {

                if (request.getCustomer()
                        == customer
                        && request.getShop()
                        == shop
                        && request.getStatus()
                        .equals("COMPLETED")) {

                    eligible = true;
                    break;
                }
            }
        }

        if (!eligible) {

            System.out.println(
                    "You can review the shop only "
                            + "after completing an order "
                            + "or service."
            );

            return;
        }

        int rating =
                readRating();

        String comment =
                readNonEmptyString(
                        "Enter your comment: "
                );

        Review review =
                new Review(
                        nextReviewId++,
                        customer,
                        shop,
                        rating,
                        comment
                );

        shop.addReview(review);
    }

    // =========================================================
    // VIEW REVIEWS
    // =========================================================

    private void viewShopReviews() {

        int shopId =
                readInt("Enter Shop ID: ");

        Shop shop =
                findShopById(shopId);

        if (shop == null) {

            System.out.println(
                    "Shop not found."
            );

            return;
        }

        shop.displayReviews();
    }

    // =========================================================
    // ADMIN LOGIN
    // =========================================================

    private void adminLogin() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("             ADMIN LOGIN");
        System.out.println("======================================");

        int adminId =
                readInt("Enter Admin ID: ");

        Admin admin =
                findAdminById(adminId);

        if (admin == null) {

            System.out.println(
                    "Invalid Admin ID."
            );

            return;
        }

        System.out.println(
                "Welcome, " + admin.getName()
        );

        adminMenu();
    }

    // =========================================================
    // ADMIN MENU
    // =========================================================

    private void adminMenu() {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("             ADMIN MENU");
            System.out.println("======================================");

            System.out.println("1. View All Customers");
            System.out.println("2. View All Shop Owners");
            System.out.println("3. View All Shops");
            System.out.println("4. View All Orders");
            System.out.println("5. View All Service Requests");
            System.out.println("6. View All Appointments");
            System.out.println("7. View System Summary");
            System.out.println("8. Logout");

            System.out.println("======================================");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    displayAllCustomers();
                    break;

                case 2:
                    displayAllShopOwners();
                    break;

                case 3:
                    displayAllShops();
                    break;

                case 4:
                    displayAllOrders();
                    break;

                case 5:
                    displayAllServiceRequests();
                    break;

                case 6:
                    displayAllAppointments();
                    break;

                case 7:
                    displaySystemSummary();
                    break;

                case 8:
                    running = false;
                    System.out.println(
                            "Admin logged out."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =========================================================
    // ADMIN - CUSTOMERS
    // =========================================================

    private void displayAllCustomers() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          ALL CUSTOMERS");
        System.out.println("======================================");

        if (customers.isEmpty()) {

            System.out.println(
                    "No customers registered."
            );

            return;
        }

        for (Customer customer : customers) {

            customer.displayUser();

            System.out.println(
                    "-----------------------------"
            );
        }
    }

    // =========================================================
    // ADMIN - SHOP OWNERS
    // =========================================================

    private void displayAllShopOwners() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("         ALL SHOP OWNERS");
        System.out.println("======================================");

        if (shopOwners.isEmpty()) {

            System.out.println(
                    "No shop owners registered."
            );

            return;
        }

        for (ShopOwner owner : shopOwners) {

            owner.displayUser();

            System.out.println(
                    "-----------------------------"
            );
        }
    }

    // =========================================================
    // ADMIN - ORDERS
    // =========================================================

    private void displayAllOrders() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("            ALL ORDERS");
        System.out.println("======================================");

        if (orders.isEmpty()) {

            System.out.println(
                    "No orders found."
            );

            return;
        }

        for (Order order : orders) {

            order.displayOrder();
        }
    }

    // =========================================================
    // ADMIN - SERVICE REQUESTS
    // =========================================================

    private void displayAllServiceRequests() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       ALL SERVICE REQUESTS");
        System.out.println("======================================");

        if (serviceRequests.isEmpty()) {

            System.out.println(
                    "No service requests found."
            );

            return;
        }

        for (ServiceRequest request
                : serviceRequests) {

            request.displayRequest();
        }
    }

    // =========================================================
    // ADMIN - APPOINTMENTS
    // =========================================================

    private void displayAllAppointments() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          ALL APPOINTMENTS");
        System.out.println("======================================");

        if (appointments.isEmpty()) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (Appointment appointment
                : appointments) {

            appointment.displayAppointment();
        }
    }

    // =========================================================
    // SYSTEM SUMMARY
    // =========================================================

    private void displaySystemSummary() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          SYSTEM SUMMARY");
        System.out.println("======================================");

        System.out.println(
                "Total Customers: "
                        + customers.size()
        );

        System.out.println(
                "Total Shop Owners: "
                        + shopOwners.size()
        );

        System.out.println(
                "Total Shops: "
                        + shops.size()
        );

        System.out.println(
                "Total Orders: "
                        + orders.size()
        );

        System.out.println(
                "Total Service Requests: "
                        + serviceRequests.size()
        );

        System.out.println(
                "Total Appointments: "
                        + appointments.size()
        );

        System.out.println("======================================");
    }

    // =========================================================
    // FIND CUSTOMER
    // =========================================================

    private Customer findCustomerById(int id) {

        for (Customer customer : customers) {

            if (customer.getUserId() == id) {
                return customer;
            }
        }

        return null;
    }

    // =========================================================
    // FIND SHOP OWNER
    // =========================================================

    private ShopOwner findShopOwnerById(int id) {

        for (ShopOwner owner : shopOwners) {

            if (owner.getUserId() == id) {
                return owner;
            }
        }

        return null;
    }

    // =========================================================
    // FIND ADMIN
    // =========================================================

    private Admin findAdminById(int id) {

        for (Admin admin : admins) {

            if (admin.getUserId() == id) {
                return admin;
            }
        }

        return null;
    }

    // =========================================================
    // FIND SHOP
    // =========================================================

    private Shop findShopById(int id) {

        for (Shop shop : shops) {

            if (shop.getShopId() == id) {
                return shop;
            }
        }

        return null;
    }

    // =========================================================
    // FIND SHOP BY OWNER
    // =========================================================

    private Shop findShopByOwner(
            ShopOwner owner) {

        for (Shop shop : shops) {

            if (shop.getOwner() == owner) {
                return shop;
            }
        }

        return null;
    }

    // =========================================================
    // FIND ORDER
    // =========================================================

    private Order findOrderById(int id) {

        for (Order order : orders) {

            if (order.getOrderId() == id) {
                return order;
            }
        }

        return null;
    }

    // =========================================================
    // FIND SERVICE REQUEST
    // =========================================================

    private ServiceRequest findServiceRequestById(
            int id) {

        for (ServiceRequest request
                : serviceRequests) {

            if (request.getRequestId() == id) {
                return request;
            }
        }

        return null;
    }

    // =========================================================
    // FIND APPOINTMENT
    // =========================================================

    private Appointment findAppointmentById(
            int id) {

        for (Appointment appointment
                : appointments) {

            if (appointment.getAppointmentId()
                    == id) {

                return appointment;
            }
        }

        return null;
    }

    // =========================================================
    // READ INTEGER
    // =========================================================

    private int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            try {

                return Integer.parseInt(
                        input.trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    // =========================================================
    // POSITIVE INTEGER
    // =========================================================

    private int readPositiveInt(
            String message) {

        while (true) {

            int value =
                    readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than zero."
            );
        }
    }

    // =========================================================
    // POSITIVE DOUBLE
    // =========================================================

    private double readPositiveDouble(
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            try {

                double value =
                        Double.parseDouble(
                                input.trim()
                        );

                if (value > 0) {
                    return value;
                }

                System.out.println(
                        "Value must be greater than zero."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    // =========================================================
    // NON EMPTY STRING
    // =========================================================

    private String readNonEmptyString(
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "This field cannot be empty."
            );
        }
    }

    // =========================================================
    // RATING
    // =========================================================

    private int readRating() {

        while (true) {

            int rating =
                    readInt("Enter rating (1-5): ");

            if (rating >= 1 && rating <= 5) {
                return rating;
            }

            System.out.println(
                    "Rating must be between 1 and 5."
            );
        }
    }
}