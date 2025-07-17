package shopping;

public class BitcoinPayment extends PaymentMethodImpl{
     @Override
    public void process(double amount) {
        System.out.println("Procesando pago con Bitcoin: $" + amount);
    } // Solo Bitcoin
}
