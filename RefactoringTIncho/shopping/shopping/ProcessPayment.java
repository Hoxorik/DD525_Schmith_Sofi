package shopping;
 //segunda interfaz, separacion del PaymentMethod, para que no sea tan grande ya que estos metodos no tienen nada q ver

public interface ProcessPayment{
    void refund(double amount);
    void printReceipt(String orderId);
    void validatePaymentDetails();
}