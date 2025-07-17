package orderGenerator;

// GodOrderProcessor.java 
import orderGenerator.auxiliares.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public class OrderProcessor {
    // Dependencias directas (violan DIP)
    private Database database;
    private EmailService emailService;
    private SMSService smsService;
    private InventoryService inventoryService;
    private ShippingService shippingService;
    private Logger logger;

    public boolean validateOrder(Order order) {
        logger.log("Validando orden " + order.getId());
        if (order.getUser().getEmail() == null || order.getUser().getEmail().isEmpty()) {
            logger.log("Error: email de usuario inválido");
            return false;
        }
        for (Product p : order.getItems()) {
            if (p.getStock() <= 0) {
                logger.log("Error: producto sin stock: " + p.getSku());
                return false;
            }
        }
        return true;
    }

    public void applyDiscount(Order order, String discountType) {
        logger.log("Aplicando descuento [" + discountType + "] a la orden " + order.getId());
        double original = order.getTotalAmount();
        double adjusted;
        switch (discountType) {
            case "STANDARD":
                // 5% de descuento
                adjusted = original * 0.95;
                break;
            case "GRACE":
                // $10 de descuento fijo
                adjusted = original - 10;
                break;
            case "STRICT":
                // 10% de descuento
                adjusted = original * 0.90;
                break;
            default:
                logger.log("Tipo de descuento desconocido: " + discountType);
                adjusted = original;
        }
        // Reemplazo por reflexión (mal práctica) para cambiar totalAmount
        try {
            Field field = Order.class.getDeclaredField("totalAmount");
            field.setAccessible(true);
            field.set(order, adjusted);
        } catch (Exception e) {
            logger.log("Error ajustando totalAmount por reflexión: " + e.getMessage());
        }
    }

    public void applyPricing(Order order) {
        logger.log("Calculando impuestos para " + order.getId());
        double taxed = order.getTotalAmount() * 1.18; // +18% IVA
        order.setStatus("PRICED");
        try {
            Field field = Order.class.getDeclaredField("totalAmount");
            field.setAccessible(true);
            field.set(order, taxed);
        } catch (Exception e) {
            logger.log("Error ajustando precio con reflexión: " + e.getMessage());
        }
    }

    public void updateInventory(Order order) {
        logger.log("Actualizando stock para " + order.getId());
        for (Product p : order.getItems()) {
            inventoryService.decreaseStock(p.getSku(), 1);
        }
    }

    public void saveOrder(Order order) {
        logger.log("Persistiendo orden " + order.getId());
        database.save("orders", order.getId(), order);
    }

    public void sendNotifications(Order order) {
        String msg = "Hola " + order.getUser().getName()
                + ", tu orden " + order.getId()
                + " por $" + order.getTotalAmount() + " fue confirmada.";
        emailService.sendEmail(order.getUser().getEmail(), "Orden Confirmada", msg);
        smsService.sendSMS(order.getUser().getPhone(), msg);
    }

    public void scheduleShipment(Order order) {
        logger.log("Agendando envío para " + order.getId());
        String tracking = UUID.randomUUID().toString();
        shippingService.schedule(order.getId(), tracking);
        order.setStatus("SHIPPED");
    }

    public void process(Order order) {
        logger.log("Iniciando procesamiento de orden " + order.getId());
        if (!validateOrder(order)) {
            logger.log("Orden " + order.getId() + " inválida. Abortando.");
            return;
        }
        applyPricing(order);
        updateInventory(order);
        saveOrder(order);
        sendNotifications(order);
        scheduleShipment(order);
        logger.log("Proceso completado para " + order.getId());
    }
}
