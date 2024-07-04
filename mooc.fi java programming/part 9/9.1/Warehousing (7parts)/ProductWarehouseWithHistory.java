public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();
        // Add initial balance to the warehouse and history
        super.addToWarehouse(initialBalance);
        this.history.add(super.getBalance());
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.history.add(super.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double takenAmount = super.takeFromWarehouse(amount);
        this.history.add(super.getBalance());
        return takenAmount;
    }

    public void printAnalysis() {
        System.out.println("Product: " + getName());
        System.out.println("History: " + this.history.toString());

        // Calculate largest amount of product

        System.out.println("Largest amount of product: " + this.history.maxValue());

        // Calculate smallest amount of product

        System.out.println("Smallest amount of product: " + this.history.minValue());

        // Calculate average amount of product
 
        System.out.println("Average: " + Math.round(this.history.average()*10) / 10.0);
    }

    public String history() {
        return this.history.toString();
    }
}