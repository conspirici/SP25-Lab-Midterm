package service;

import process.ProcessStep;

public class ShippingService {

    public void handleShipping(String item) {
        InventoryService inventory = InventoryService.getInstance();

        if (inventory.checkAvailability(item)) {
            System.out.println("Item available in inventory.");

            ProcessStep qc = ProcessFactory.getProcess("qualitycheck");
            ProcessStep pack = ProcessFactory.getProcess("packaging");
            ProcessStep ship = ProcessFactory.getProcess("shipment");

            qc.execute(item);
            pack.execute(item);
            ship.execute(item);

            NotificationService.getInstance().notifyAdmin("Shipping process started for: " + item);
        } else {
            System.out.println("Item not available in inventory.");
        }
    }
}
