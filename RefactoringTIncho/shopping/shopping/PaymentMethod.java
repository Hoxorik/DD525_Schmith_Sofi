package shopping;
//code smell: god class

public interface PaymentMethod {
    void processCreditCard(double amount);
    void processPaypal(double amount);
    void processBitcoin(double amount);
    /*void refund(double amount);
    void printReceipt(String orderId);
    void validatePaymentDetails();*/
}
