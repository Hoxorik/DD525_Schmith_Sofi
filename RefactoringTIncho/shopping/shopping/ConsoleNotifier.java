public class ConsoleNotifier implements Notifier {
    @Override
    public void notify(User user, String orderId, double total) {
        System.out.println("Enviando email a " + user.getEmail() + ":");
        System.out.println("Estimado " + user.getName() + ", su orden " + orderId + " de importe $" + total + " ha sido confirmada.");
        System.out.println("Gracias por su compra.");

        System.out.println("Enviando SMS a " + user.getPhoneNumber() + ":");
        System.out.println("Orden " + orderId + " confirmada. Total: $" + total);
    }
}
