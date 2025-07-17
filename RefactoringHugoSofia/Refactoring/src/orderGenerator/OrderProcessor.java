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
    private Map<String, DiscountStrategy> discountStrategies;
    private ApplyDiscountStep applyDiscount;
    private ApplyPricingStep ApplyPricingStep;
    private PricingStep PricingStep;
    private SaveOrderStep saveOrder;
    private ScheduleShipmentStep ScheduleShipmentStep;
    private SendNotificationsStep SendNotificationsStep;
    private UpdateInventoryStep UpdateInventoryStep;
    private ValidateOrder ValidateOrder;

    //⚠️ emji para idetnficar rapido
    //buenasss, constructor para poder hacer que las clases no se instancien con new() sino que por abstraccion
    // antes:   private Database database = new Database();
    //despues:  private Database database;
    public OrderProcessor(Database database,List<OrderStep> steps,List<DiscountStrategy> strategies,  EmailService emailService, SMSService smsService, InventoryService inventoryService, ShippingService shippingService, Logger logger) {
        this.database = database;
        this.emailService = emailService;
        this.smsService = smsService;
        this.inventoryService = inventoryService;
        this.shippingService = shippingService;
        this.logger = logger;
        this.steps = steps;

        discountStrategies = new HashMap<>();
        for (DiscountStrategy s : strategies) {
            discountStrategies.put(s.getName(), s);
        }

         this.validateOrder = new ValidateOrder(logger);
        this.applyDiscount = new ApplyDiscountStep(logger, discountStrategies, discountType);
        this.applyPricing = new ApplyPricingStep(logger);
        this.saveOrder = new SaveOrderStep(database, logger);
        this.scheduleShipment = new ScheduleShipmentStep(shippingService, logger);
        this.sendNotifications = new SendNotificationsStep(emailService, smsService, logger);
        this.updateInventory = new UpdateInventoryStep(inventoryService, logger);
    }




public void process(Order order) {
    logger.log("Iniciando procesamiento de orden " + order.getId());

    if (!validateOrder.execute(order)) {
        logger.log("Falló ValidateOrder");
    }

    if (!applyDiscount.execute(order)) {
        logger.log("Falló ApplyDiscountStep");
    }

    if (!applyPricing.execute(order)) {
        logger.log("Falló ApplyPricingStep");
    }

    if (!saveOrder.execute(order)) {
        logger.log("Falló SaveOrderStep");
    }

    if (!scheduleShipment.execute(order)) {
        logger.log("Falló ScheduleShipmentStep");
    }

    if (!sendNotifications.execute(order)) {
        logger.log("Falló SendNotificationsStep");
    }

    if (!updateInventory.execute(order)) {
        logger.log("Falló UpdateInventoryStep");
    }

    logger.log("Proceso completado para la orden " + order.getId());
}

}
