package dao;

import java.util.Arrays;
import java.util.List;

public class InventoryDAO {

    private static final List<String> availableItems = Arrays.asList(
        "Laptop", "Phone", "Tablet", "Keyboard", "Chair"
    );

    public static boolean isItemAvailable(String itemName) {
        for (String item : availableItems) {
            if (item.equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
}
