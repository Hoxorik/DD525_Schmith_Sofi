package shopping;
//hace demaciadas cosas, tiene god class
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCartManager {
    private List<Product> items = new ArrayList<>();

    private FileLogger logger;
    private PaymentMethod paymentMethod;
    private OrderRepository orderRepository;

    public ShoppingCartManager(OrderRepository orderRepository, FileLogger logger, PaymentMethod paymentMethod) {
        this.orderRepository = orderRepository;
        this.FileLogger = logger;
        this.OrderRepository = paymentMethod;
    }
/*
    public void checkout(User user, String paymentType) {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }

        logger.log("Usuario " + user.getName() + " hace checkout, total: " + total);

        switch (paymentType) {
            case "CREDIT_CARD":
                paymentMethod.validatePaymentDetails();
                paymentMethod.processCreditCard(total);
                break;
            case "PAYPAL":
                paymentMethod.validatePaymentDetails();
                paymentMethod.processPaypal(total);
                break;
            case "BITCOIN":
                paymentMethod.validatePaymentDetails();
                paymentMethod.processBitcoin(total);
                break;
            default:
                System.out.println("Método de pago no soportado");
                return;
        }

        String orderId = UUID.randomUUID().toString();
        orderRepository.saveOrder(orderId, user, total); // ya no depende de Database

        //new Database().saveOrder(orderId, user, total);   // DIP violado

        System.out.println("Enviando email a " + user.getEmail() + ":");
        System.out.println("Estimado " + user.getName() + ", su orden " + orderId + " de importe $" + total + " ha sido confirmada.");
        System.out.println("Gracias por su compra.");

        System.out.println("Enviando SMS a " + user.getPhoneNumber() + ":");
        System.out.println("Orden " + orderId + " confirmada. Total: $" + total);

        items.clear();
    }*/ //Hace demaciado, asi que la voy a fraccionar en dos clases...

    public void addItem(Product p) {
        items.add(p);
    }
    public void removeItem(Product p) {
        items.remove(p);
    }
}