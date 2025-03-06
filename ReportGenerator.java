import java.util.List;

class Property {
    private final String name;
    private final double rentAmount;
    private final String ownerName;
    private final String location;
    private static final double PREMIUM_THRESHOLD = 2000.0;

    public Property(String name, double rentAmount, String ownerName, String location) {
        this.name = name;
        this.rentAmount = rentAmount;
        this.ownerName = ownerName;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLocation() {
        return location;
    }

    public boolean isPremium() {
        return rentAmount > PREMIUM_THRESHOLD;
    }

    public double getYearlyRent() {
        return rentAmount * 12;
    }

    public void printPropertyDetails() {
        System.out.println("Property: " + name + " , Rent Amount: $" + rentAmount +
                " , Owner: " + ownerName + " , Location: " + location);
    }
}

class FinancialReport {
    private final String reportTitle;
    private final List<Property> properties;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }

    public double calculateTotalRent() {
        return properties.stream().mapToDouble(Property::getRentAmount).sum();
    }

    public void generateReport() {
        System.out.println("Financial Report: " + reportTitle);
        System.out.println("----------------------------");

        properties.forEach(property -> {
            property.printPropertyDetails();
            System.out.println(property.isPremium() ? "This is a premium property." : "This is a standard property.");
            System.out.println("Yearly Rent: $" + property.getYearlyRent());
            System.out.println("--------------------");
        });

        System.out.println("Total Rent Amount: $" + calculateTotalRent());
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        Property property1 = new Property("Apartment A", 1500.0, "John Doe", "City Center");
        Property property2 = new Property("House B", 2500.0, "Jane Smith", "Suburb");
        Property property3 = new Property("Condo C", 1800.0, "Bob Johnson", "Downtown");

        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary",
                List.of(property1, property2, property3));
        financialReport.generateReport();
    }
}
