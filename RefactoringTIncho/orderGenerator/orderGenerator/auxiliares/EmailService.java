package orderGenerator.auxiliares;

public class EmailService {
    public void sendEmail(String to, String subject, String body) {
        System.out.println("[EMAIL] Para: " + to + " | Asunto: " + subject);
        System.out.println("       " + body);
    }
}