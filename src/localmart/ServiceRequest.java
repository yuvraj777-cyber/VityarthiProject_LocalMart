package localmart;

public class ServiceRequest {

    private int requestId;
    private Customer customer;
    private Shop shop;
    private Service service;

    private String requirement;
    private String preferredDate;
    private String contactMethod;
    private String status;

    public ServiceRequest(int requestId,
                          Customer customer,
                          Shop shop,
                          Service service,
                          String requirement,
                          String preferredDate,
                          String contactMethod) {

        this.requestId = requestId;
        this.customer = customer;
        this.shop = shop;
        this.service = service;
        this.requirement = requirement;
        this.preferredDate = preferredDate;
        this.contactMethod = contactMethod;

        status = "REQUESTED";
    }

    public int getRequestId() {
        return requestId;
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

    public String getRequirement() {
        return requirement;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public String getStatus() {
        return status;
    }

    // ==========================================
    // UPDATE SERVICE REQUEST STATUS
    // ==========================================

    public boolean updateStatus(String newStatus) {

        // REQUESTED -> CONTACTED
        if (status.equals("REQUESTED")
                && newStatus.equals("CONTACTED")) {

            status = newStatus;
            return true;
        }

        // CONTACTED -> APPOINTMENT_SCHEDULED
        if (status.equals("CONTACTED")
                && newStatus.equals("APPOINTMENT_SCHEDULED")) {

            status = newStatus;
            return true;
        }

        // APPOINTMENT_SCHEDULED -> SITE_VISIT
        if (status.equals("APPOINTMENT_SCHEDULED")
                && newStatus.equals("SITE_VISIT")) {

            status = newStatus;
            return true;
        }

        // SITE_VISIT -> QUOTATION
        if (status.equals("SITE_VISIT")
                && newStatus.equals("QUOTATION")) {

            status = newStatus;
            return true;
        }

        // QUOTATION -> ACCEPTED
        if (status.equals("QUOTATION")
                && newStatus.equals("ACCEPTED")) {

            status = newStatus;
            return true;
        }

        // ACCEPTED -> IN_PROGRESS
        if (status.equals("ACCEPTED")
                && newStatus.equals("IN_PROGRESS")) {

            status = newStatus;
            return true;
        }

        // IN_PROGRESS -> COMPLETED
        if (status.equals("IN_PROGRESS")
                && newStatus.equals("COMPLETED")) {

            status = newStatus;
            return true;
        }

        return false;
    }

    // ==========================================
    // DISPLAY REQUEST
    // ==========================================

    public void displayRequest() {

        System.out.println(
                "\n============================"
        );

        System.out.println(
                "Service Request ID: " + requestId
        );

        System.out.println(
                "Customer: " + customer.getName()
        );

        System.out.println(
                "Shop: " + shop.getShopName()
        );

        System.out.println(
                "Service: " + service.getServiceName()
        );

        System.out.println(
                "Requirement: " + requirement
        );

        System.out.println(
                "Preferred Date: " + preferredDate
        );

        System.out.println(
                "Contact Method: " + contactMethod
        );

        System.out.println(
                "Status: " + status
        );

        System.out.println(
                "============================"
        );
    }
}