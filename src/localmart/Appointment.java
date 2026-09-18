package localmart;

public class Appointment {

    private int appointmentId;

    private Customer customer;
    private Shop shop;
    private Service service;
    private ServiceRequest serviceRequest;

    private String date;
    private String time;
    private String status;

    public Appointment(int appointmentId,
                       Customer customer,
                       Shop shop,
                       Service service,
                       ServiceRequest serviceRequest,
                       String date,
                       String time) {

        this.appointmentId = appointmentId;
        this.customer = customer;
        this.shop = shop;
        this.service = service;
        this.serviceRequest = serviceRequest;

        this.date = date;
        this.time = time;

        status = "SCHEDULED";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Shop getShop() {
        return shop;
    }

    public Service getService() {
        return service;
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public boolean updateStatus(String newStatus) {

        if (status.equals("SCHEDULED")
                && newStatus.equals("COMPLETED")) {

            status = newStatus;
            return true;
        }

        if (status.equals("SCHEDULED")
                && newStatus.equals("CANCELLED")) {

            status = newStatus;
            return true;
        }

        return false;
    }

    public void displayAppointment() {

        System.out.println();
        System.out.println("============================");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Shop: " + shop.getShopName());
        System.out.println("Service: " + service.getServiceName());
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Status: " + status);
        System.out.println("============================");
    }
}