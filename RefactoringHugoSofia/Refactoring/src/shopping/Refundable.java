package shopping;

public class Refundable extends  PaymentMethodImpl{
    @Override
    public void refund(double amount) {
        System.out.println("Reembolsando: $" + amount);
    } // Solo reembolso
}
