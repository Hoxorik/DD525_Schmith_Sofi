package shopping;

// PaymentMethodImpl.java
public class PaymentMethodImpl implements PaymentMethod, ProcessPayment {

    @Override
    public void processCreditCard(double amount) {
        System.out.println("Procesando pago con tarjeta de crédito: $" + amount);
    }

    @Override
    public void processPaypal(double amount) {
        System.out.println("Procesando pago con PayPal: $" + amount);
    }

    @Override
    public void processBitcoin(double amount) {
        System.out.println("Procesando pago con Bitcoin: $" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Reembolsando: $" + amount);
    }

    @Override
    public void printReceipt(String orderId) {
        System.out.println("Imprimiendo recibo para orden: " + orderId);
    }

    @Override
    public void validatePaymentDetails() {
        System.out.println("Validando detalles de pago...");
    }
}

