package shopping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCartManager {
    private List<Product> items = new ArrayList<>();
    private FileLogger logger;
    private Database database;
    private Map<String, PaymentMethodImpl> paymentStrategies;
    
    //  ⚠️ constructor para inyección como en los de antes, me da paja volver a escribir la expliacion
   public ShoppingCartManager(FileLogger logger, PaymentValidatable paymentValidatable, Database database, Map<String, PaymentMethodImpl> paymentStrategies) {
    this.logger = logger;
    this.paymentValidatable = paymentValidatable;
    this.database = database;
    this.paymentStrategies = paymentStrategies;
}

    public void checkout(User user) {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }

        //Usamos un strategy para volar el switch

        PaymentMethodImpl strategy = paymentStrategies.get(paymentType);

        paymentValidatable.validatePaymentDetails(); // aún compartido
        strategy.process(total);

        String orderId = UUID.randomUUID().toString();
        database.saveOrder(orderId, user, total);
        notify(user, orderId, total);
        items.clear();

        logger.log("Usuario " + user.getName() + " hace checkout, total: " + total);

        

        }
        //solo usa la abstraccion necesaria

        String orderId = UUID.randomUUID().toString();
        // antes :new Database().saveOrder(orderId, user, total);   // DIP violado
        //ahora:
        database.saveOrder(orderId, user, total);

        /*System.out.println("Enviando email a " + user.getEmail() + ":");
        System.out.println("Estimado " + user.getName() + ", su orden " + orderId + " de importe $" + total + " ha sido confirmada.");
        System.out.println("Gracias por su compra.");

        System.out.println("Enviando SMS a " + user.getPhoneNumber() + ":");
        System.out.println("Orden " + orderId + " confirmada. Total: $" + total);*/
        notify(user, orderId, total);

        items.clear();
    }

    public void notify(User user, String orderId, double total) {
        System.out.println("Enviando email a " + user.getEmail() + ":");
        System.out.println("Estimado " + user.getName() + ", su orden " + orderId + " de importe $" + total + " ha sido confirmada.");
        System.out.println("Gracias por su compra.");

        System.out.println("Enviando SMS a " + user.getPhoneNumber() + ":");
        System.out.println("Orden " + orderId + " confirmada. Total: $" + total);
    }
    public void addItem(Product p) {
        items.add(p);
    }
    public void removeItem(Product p) {
        items.remove(p);
    }
}