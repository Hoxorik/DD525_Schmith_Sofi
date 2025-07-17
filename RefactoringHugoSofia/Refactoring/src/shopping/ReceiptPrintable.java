package shopping;

public class ReceiptPrintable extends PaymentMethodImpl{
   @Override
    public void printReceipt(String orderId) {
        System.out.println("Imprimiendo recibo para orden: " + orderId);
    } // Solo recibo
}
