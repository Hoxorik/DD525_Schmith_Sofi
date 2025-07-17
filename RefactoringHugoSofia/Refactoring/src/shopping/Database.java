package shopping;

public class Database {
    public void saveOrder(String orderId, User user, double total) {
        System.out.println("Guardando orden " + orderId + " para " + user.getName());
    }
}