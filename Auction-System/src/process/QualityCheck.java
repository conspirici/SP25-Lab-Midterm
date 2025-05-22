package process;

public class QualityCheck implements ProcessStep {
    public void execute(String item) {
        System.out.println("Quality check passed for: " + item);
    }
}
