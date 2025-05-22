package ui;

import service.ShippingService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class ShippingUI extends JFrame {
    private JTextField itemField;
    private JTextArea outputArea;
    private ShippingService shippingService;

    public ShippingUI() {
        shippingService = new ShippingService();

        setTitle("Auction System – Shipping Request");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel with label and input
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter Item to Ship:");
        itemField = new JTextField(20);
        JButton shipButton = new JButton("Ship Item");

        topPanel.add(label);
        topPanel.add(itemField);
        topPanel.add(shipButton);

        // Center panel for output logs
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Action listener
        shipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(""); // clear previous logs
                String item = itemField.getText().trim();

                if (item.isEmpty()) {
                    outputArea.setText("⚠ Please enter an item name.");
                } else {
                    // Redirect system output to text area
                    PrintStream printStream = new PrintStream(new TextAreaOutputStream(outputArea));
                    System.setOut(printStream);
                    System.setErr(printStream);

                    // Run shipping process
                    shippingService.handleShipping(item);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShippingUI().setVisible(true);
        });
    }
}
