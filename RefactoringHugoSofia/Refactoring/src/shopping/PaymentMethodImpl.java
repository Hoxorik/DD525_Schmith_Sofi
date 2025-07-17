package shopping;

// PaymentMethodImpl.java
public abstract class PaymentMethodImpl {

    abstract void process(double amount);

    public void validatePaymentDetails() {
        System.out.println("Validando detalles de pago...");
    }
}

