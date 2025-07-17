package orderGenerator.auxiliares;

public class InventoryService implements IInventory {
    @Override
    public void decreaseStock(String sku, int qty) {
        System.out.println("[STOCK] Disminuyendo " + qty + " unidades de " + sku);
    }
}