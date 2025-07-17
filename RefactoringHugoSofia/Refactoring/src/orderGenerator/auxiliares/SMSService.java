package orderGenerator.auxiliares;

public class SMSService {
    public void sendSMS(String phone, String message) {
        System.out.println("[SMS] Para: " + phone + " -> " + message);
    }
}
