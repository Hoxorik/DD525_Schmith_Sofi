package orderGenerator;

import java.util.List;

public class Order {
    private String id;
    private User user;
    private List<Product> items;
    private double totalAmount;
    private String status;

    public Order(String id, User user, List<Product> items) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.status = "NEW";
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public List<Product> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
