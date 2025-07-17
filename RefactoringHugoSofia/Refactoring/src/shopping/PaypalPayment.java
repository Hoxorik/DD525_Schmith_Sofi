package shopping;

public interface PaypalPayment extends PaymentMethodImpl{
    @Override
    public void processPaypal(double amount) {
        System.out.println("Procesando pago con PayPal: $" + amount);
    }// Solo Paypal
}
