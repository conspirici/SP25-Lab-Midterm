package service;

import observer.*;

public class NotificationService {
    private static NotificationService instance;
    private final ShippingNotifier notifier;

    private NotificationService() {
        notifier = new ShippingNotifier();
        notifier.addObserver(new AdminObserver("Admin-1"));
    }

    public static NotificationService getInstance() {
        if (instance == null)
            instance = new NotificationService();
        return instance;
    }

    public void notifyAdmin(String message) {
        notifier.notifyObservers(message);
    }
}
