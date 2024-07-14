package com.cristhianvaldivia.aluraconversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterPanel extends JPanel {

    private final JComboBox<String> comboboxFrom;
    private final JComboBox<String> comboboxTo;
    private final JTextField amountTextField;

    private static final String[] CURRENCIES = {"USD - Dollar", "EUR - Euro", "PEN - Nuevo Sol Peruano",
        "CAD - Dolar Canadiense", "GBP - Libra Esterlina",
        "JPY - Yen", "CNH - Yuan", "SEK - Corona Sueca"};

    public CurrencyConverterPanel() {
        JLabel fromLabel = new JLabel("De");
        comboboxFrom = new JComboBox<>(CURRENCIES);

        JLabel toLabel = new JLabel("a:");
        comboboxTo = new JComboBox<>(CURRENCIES);

        JLabel amountLabel = new JLabel("Monto:");
        amountTextField = new JTextField(10);

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(new ConvertButtonListener());

        add(fromLabel);
        add(comboboxFrom);
        add(toLabel);
        add(comboboxTo);
        add(amountLabel);
        add(amountTextField);
        add(convertButton);
    }

    private class ConvertButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String from = comboboxFrom.getSelectedItem().toString().substring(0, 3);
            String to = comboboxTo.getSelectedItem().toString().substring(0, 3);
            String amount = amountTextField.getText();
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Favor de escribir un monto", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else {
                CurrencyConverter converter = new CurrencyConverter();
                String result = converter.convert(from, to, amount);
                if (result != null) {
                    String message = "El monto convertido de " + amount + " " + from + " es de " + result + " " + to;
                    JOptionPane.showMessageDialog(null, message, "Resultado de la Conversión", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la conversión", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
