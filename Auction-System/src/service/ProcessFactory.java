package service;

import process.*;

public class ProcessFactory {
    public static ProcessStep getProcess(String step) {
        return switch (step.toLowerCase()) {
            case "qualitycheck" -> new QualityCheck();
            case "packaging" -> new Packaging();
            case "shipment" -> new Shipment();
            default -> throw new IllegalArgumentException("Unknown step: " + step);
        };
    }
}
