package com.cristhianvaldivia.aluraconversor;

import javax.swing.*;

public class CurrencyConverterApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Convertidor de Divisas API: api.apilayer.com/exchangerates_data");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new CurrencyConverterPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
