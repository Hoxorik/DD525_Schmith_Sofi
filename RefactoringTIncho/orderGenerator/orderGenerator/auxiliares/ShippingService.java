package orderGenerator.auxiliares;

public class ShippingService {
    public void schedule(String orderId, String trackingCode) {
        System.out.println("[SHIP] Orden " + orderId + " track: " + trackingCode);
    }
}