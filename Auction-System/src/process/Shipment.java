package process;

public class Shipment implements ProcessStep {
    public void execute(String item) {
        System.out.println("Shipment initiated for: " + item);
    }
}
