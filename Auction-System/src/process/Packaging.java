package process;

public class Packaging implements ProcessStep {
    public void execute(String item) {
        System.out.println("Packaging completed for: " + item);
    }
}
