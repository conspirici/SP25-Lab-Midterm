package observer;

public class AdminObserver implements Observer {
    private final String adminName;

    public AdminObserver(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public void update(String message) {
        System.out.println("Admin Notification (" + adminName + "): " + message);
    }
}
