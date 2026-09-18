# LocalMart – Local Commerce Management System

## Project Overview

LocalMart is a Java-based console application designed to connect
customers with local businesses through a unified local commerce
management system.

The system supports two major types of local business interactions:

1. Product-based transactions
2. Service-based and customized service requests

Customers can discover shops, view products and services, place
product orders, request customized services, view appointments, and
provide ratings and reviews.

Shop owners can manage their shops, products, services, orders,
service requests, appointments, and customer reviews.

Administrators can monitor the overall system.

---

# Problem Statement

Local businesses often operate differently from standardized
e-commerce platforms.

Some businesses sell ready-to-buy products, while others provide
customized products, consultation, installation, home-related
services, or other services.

Standardized e-commerce workflows may not represent these different
local business requirements effectively.

Customers may also find it difficult to discover local businesses,
compare their ratings and reviews, purchase available products, or
request customized services through a single platform.

LocalMart addresses this problem by providing a unified system for
discovering local businesses and supporting both product purchasing
and service/customized request workflows.

---

# Objectives

The main objectives of LocalMart are:

- To connect customers with local businesses.
- To provide a centralized system for managing local shops.
- To support both product-based and service-based businesses.
- To allow customers to browse products and services.
- To allow customers to place product orders.
- To allow customers to request customized services.
- To support appointment scheduling for service requests.
- To manage product stock.
- To manage order and service request status.
- To allow customers to provide ratings and reviews.
- To provide administrators with system-level monitoring.
- To demonstrate Java Object-Oriented Programming concepts.

---

# Scope

The current scope of LocalMart includes:

- Customer registration and login.
- Shop owner registration and login.
- Admin login.
- Local shop management.
- Product management.
- Service management.
- Product ordering.
- Product stock validation.
- Service request management.
- Appointment scheduling.
- Order status management.
- Service request status management.
- Appointment status management.
- Customer ratings and reviews.
- Shop average rating calculation.
- System monitoring through the Admin module.
- In-memory data management using Java ArrayList.

The current version is a console-based Java application.

It does not use an external database, web interface, mobile
application, online payment gateway, or external API.

---

# Target Users

## 1. Customers

Customers can:

- Register and login.
- View their profile.
- View available shops.
- Search shops.
- Browse products.
- Browse services.
- Place product orders.
- View their orders.
- Request services.
- View their service requests.
- View appointments.
- Add ratings and reviews.
- View shop reviews.

## 2. Shop Owners

Shop owners can:

- Register and login.
- View their shop.
- Add products.
- View products.
- Add services.
- View services.
- View customer orders.
- Update order status.
- View service requests.
- Update service request status.
- View appointments.
- Update appointment status.
- View customer reviews.

## 3. Administrator

The administrator can:

- Login.
- View all customers.
- View all shop owners.
- View all shops.
- View all orders.
- View all service requests.
- View all appointments.
- View the system summary.

---

# Main Features

## Customer Module

The Customer module provides:

- Customer registration.
- Customer login.
- Profile viewing.
- Shop discovery.
- Shop searching.
- Product browsing.
- Service browsing.
- Product ordering.
- Service requests.
- Appointment viewing.
- Order history.
- Service request history.
- Ratings and reviews.

---

## Shop Owner Module

The Shop Owner module provides:

- Shop owner registration.
- Shop owner login.
- Shop viewing.
- Product management.
- Service management.
- Order management.
- Service request management.
- Appointment management.
- Review viewing.

---

## Admin Module

The Admin module provides system-level monitoring.

The administrator can view:

- Customers.
- Shop owners.
- Shops.
- Orders.
- Service requests.
- Appointments.
- System summary.

---

# Product Order Workflow

The product ordering workflow is:

```text
Customer
    |
    v
Select Shop
    |
    v
View Products
    |
    v
Select Product
    |
    v
Enter Quantity
    |
    v
Check Stock
    |
    v
Is Stock Available?
    |
    +---------- NO ----------> Insufficient Stock
    |
   YES
    |
    v
Create Order
    |
    v
PLACED
    |
    v
CONFIRMED
    |
    v
PROCESSING
    |
    v
COMPLETED
The product quantity is reduced when the order is successfully placed.
Service Request Workflow
LocalMart supports service-based and customized requirements.
The workflow is:
Customer
    |
    v
Select Shop
    |
    v
Select Service
    |
    v
Enter Requirement
    |
    v
Enter Preferred Date
    |
    v
Enter Contact Method
    |
    v
Create Service Request
    |
    v
REQUESTED
    |
    v
CONTACTED
    |
    v
APPOINTMENT_SCHEDULED
    |
    v
Appointment Created
    |
    v
SITE_VISIT
    |
    v
QUOTATION
    |
    v
ACCEPTED
    |
    v
IN_PROGRESS
    |
    v
COMPLETED
When the service request reaches
APPOINTMENT_SCHEDULED, the system automatically creates an
appointment.
The appointment uses the customer's preferred date, while the shop
owner enters the appointment time.
Appointment Workflow
Appointments follow this workflow:
Appointment Created
        |
        v
    SCHEDULED
       / \
      /   \
     v     v
COMPLETED  CANCELLED
The shop owner can update the appointment status.
Review Workflow
Customers can provide a review after completing an order or service.
Completed Order
      OR
Completed Service
      |
      v
   Add Review
      |
      v
Enter Rating (1-5)
      |
      v
Enter Comment
      |
      v
 Review Added
      |
      v
Shop Average Rating Updated
      |
      v
 View Shop Reviews
Review Rules
- A customer can review a shop only after completing an order or
  service.
- A customer cannot review the same shop more than once.
- Ratings are given from 1 to 5.
- The shop's average rating is calculated from its reviews.
Order Status
Product orders follow the following status sequence:
PLACED
   |
   v
CONFIRMED
   |
   v
PROCESSING
   |
   v
COMPLETED
Only valid status transitions are accepted by the system.
Service Request Status
Service requests follow this sequence:
REQUESTED
   |
   v
CONTACTED
   |
   v
APPOINTMENT_SCHEDULED
   |
   v
SITE_VISIT
   |
   v
QUOTATION
   |
   v
ACCEPTED
   |
   v
IN_PROGRESS
   |
   v
COMPLETED
Only valid status transitions are accepted.
Appointment Status
Appointments support:
SCHEDULED
   |
   +------> COMPLETED
   |
   +------> CANCELLED
OOP Concepts Used
The project demonstrates the following Java Object-Oriented
Programming concepts:
Classes and Objects
The system is divided into multiple classes representing real-world
entities such as:
- User
- Customer
- ShopOwner
- Admin
- Shop
- Product
- Service
- Order
- ServiceRequest
- Appointment
- Review
Inheritance
Customer, ShopOwner, and Admin inherit from the User class.
              User
            /  |  \
           /   |   \
          /    |    \
    Customer  ShopOwner  Admin
Method Overriding
The displayUser() method is overridden by:
- Customer
- ShopOwner
- Admin
Encapsulation
Class attributes are kept private or protected and are accessed
through methods where appropriate.
Association
Different objects are associated with each other.
Examples:
- Shop has Products.
- Shop has Services.
- Customer places Orders.
- Customer creates ServiceRequests.
- ServiceRequest is associated with an Appointment.
- Customer provides Reviews for Shops.
ArrayList
Java ArrayList is used for in-memory management of customers,
shops, orders, service requests, appointments, and other objects.
Technology Stack
Component	Technology
Programming Language	Java
Java Version	JDK 21
User Interface	Console / Command Line
Data Storage	In-memory ArrayList
IDE	Visual Studio Code
Project Type	Java OOP Console Application


Project Structure
LocalMart/
|
├── src/
│   └── localmart/
│       ├── User.java
│       ├── Customer.java
│       ├── ShopOwner.java
│       ├── Admin.java
│       ├── Product.java
│       ├── Service.java
│       ├── Shop.java
│       ├── Review.java
│       ├── Order.java
│       ├── ServiceRequest.java
│       ├── Appointment.java
│       ├── LocalMartSystem.java
│       └── Main.java
│
├── docs/
│   ├── class-diagram.png
│   ├── architecture.png
│   ├── workflow.png
│   ├── use-case.png
│   ├── sequence-order.png
│   └── sequence-service.png
│
├── statement.md
└── README.md

How to Run the Project
Prerequisites
Make sure Java JDK 21 or later is installed.
You can verify Java installation using:
java -version
Check the Java compiler using:
javac -version
Compile the Project
Open the terminal in the main LocalMart project folder.
Run:
javac -d out src\localmart\*.java
This compiles all Java source files and stores the compiled classes
inside the out folder.
Run the Project
After successful compilation, run:
java -cp out localmart.Main
The application will display the LocalMart main menu.
Main Menu
The application provides three user roles:
======================================
          LOCALMART SYSTEM
======================================
1. Customer
2. Shop Owner
3. Admin
4. Exit
======================================
Data Storage
The current version uses Java ArrayList collections for in-memory
data storage.
No external database is used.
Therefore, the data exists only while the application is running.
When the application is closed, the in-memory data is cleared.
Validation and Error Handling
The application contains basic input validation.
Examples include:
- Invalid integer input handling.
- Positive quantity validation.
- Positive price validation.
- Empty input validation.
- Rating validation from 1 to 5.
- Product stock validation.
- Duplicate product ID validation.
- Duplicate service ID validation.
- Invalid order status transition handling.
- Invalid service request status transition handling.
- Invalid appointment status transition handling.
- Shop and user existence validation.
Testing
The following major workflows have been tested:
Test Case	Expected Result
Customer Registration	Customer is registered successfully
Customer Login	Customer menu is displayed
Shop Owner Registration	Owner and shop are created
Shop Owner Login	Owner shop menu is displayed
Add Product	Product is added to shop
View Products	Products are displayed
Add Service	Service is added to shop
View Services	Services are displayed
Place Product Order	Order is created and stock is reduced
Insufficient Stock	Order is rejected
Update Order Status	Valid status transition is accepted
Request Service	Service request is created
Update Service Request	Valid status transition is accepted
Appointment Creation	Appointment is automatically created
View Appointment	Appointment details are displayed
Update Appointment	Appointment status is updated
Complete Service	Service reaches COMPLETED status
Add Review	Review is added after completion
Duplicate Review	Second review for same shop is rejected
Admin Login	Admin menu is displayed
System Summary	System statistics are displayed


Documentation
The docs folder contains the project design diagrams:
UML Class Diagram
Shows the classes of the LocalMart system and their relationships.
System Architecture Diagram
Shows the architecture and layers of the Java console application.
Overall Workflow Diagram
Shows the overall operation of the system.
UML Use Case Diagram
Shows interactions between Customer, Shop Owner, Admin, and the
LocalMart system.
Product Order Sequence Diagram
Shows the interaction sequence during product ordering.
Service Request Sequence Diagram
Shows the interaction sequence from service request to appointment
and service completion.
Project Design
The project follows a modular object-oriented structure.
Major functional modules include:
1. Customer Management
2. Shop Owner Management
3. Shop Management
4. Product Management
5. Service Management
6. Order Management
7. Service Request Management
8. Appointment Management
9. Review Management
10. Admin Monitoring
Non-Functional Requirements
Performance
The system should respond quickly to user commands and basic
operations during normal console usage.
Usability
The console menus and messages should be simple and understandable
for users.
Reliability
The system validates user input and prevents invalid operations such
as ordering more products than available stock.
Maintainability
The system is divided into multiple classes so that individual
functional areas can be modified independently.
Error Handling
Invalid numeric inputs, empty inputs, invalid status transitions,
and unavailable products are handled by the application.
Future Enhancements
The following features may be considered for future versions:
- Database integration.
- Web-based user interface.
- Mobile application.
- Online payment integration.
- Location-based shop discovery.
- Advanced search and filtering.
- Customer-business communication.
- Notification system.
- Order delivery tracking.
- Persistent user accounts.
These features are not part of the current implementation.
Limitations
The current version has the following limitations:
- Data is stored only in memory.
- Data is lost when the application terminates.
- The system is console-based.
- No online payment system is implemented.
- No external database is implemented.
- No web or mobile interface is implemented.
- Appointment date and time are stored as strings.
- The system does not provide real-world delivery tracking.
Conclusion
LocalMart demonstrates how Java Object-Oriented Programming can be
used to design a practical local commerce management system.
The project supports both product-based transactions and
service-based/customized service workflows.
Through its Customer, Shop Owner, and Admin modules, the system
provides functionality for shop discovery, product ordering, service
requests, appointments, order processing, and customer reviews.
The project also demonstrates important Java concepts such as
classes, objects, inheritance, method overriding, encapsulation,
association, constructors, and ArrayList-based data management.
Project Information
Project Name: LocalMart – Local Commerce Management System
Project Type: Java OOP Console Application
Course: Java / Object-Oriented Programming
Purpose: VITyarthi Project
Programming Language: Java
Java Version: JDK 21