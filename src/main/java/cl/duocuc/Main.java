package cl.duocuc;

import cl.duocuc.vista.VentanaPrincipal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ejecutándose");

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}