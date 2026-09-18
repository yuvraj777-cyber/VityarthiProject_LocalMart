package localmart;

public class Service {

    private int serviceId;
    private String serviceName;
    private String description;
    private double startingPrice;

    public Service(int serviceId,
                   String serviceName,
                   String description,
                   double startingPrice) {

        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.startingPrice = startingPrice;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void displayService() {

        System.out.println("Service ID: " + serviceId);
        System.out.println("Service Name: " + serviceName);
        System.out.println("Description: " + description);
        System.out.println("Starting Price: ₹" + startingPrice);
        System.out.println("-----------------------------");
    }
}