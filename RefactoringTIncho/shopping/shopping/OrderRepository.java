public interface OrderRepository {
    void saveOrder(String orderId, User user, double total);
}