package service;

import dao.InventoryDAO;

public class InventoryService {
    private static InventoryService instance;

    private InventoryService() {}

    public static InventoryService getInstance() {
        if (instance == null)
            instance = new InventoryService();
        return instance;
    }

    public boolean checkAvailability(String item) {
        return InventoryDAO.isItemAvailable(item);
    }
}
