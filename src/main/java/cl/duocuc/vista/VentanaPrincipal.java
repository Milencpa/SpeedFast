package cl.duocuc.vista;

import cl.duocuc.dao.ConexionDB;
import cl.duocuc.dao.PedidoDAO;
import cl.duocuc.dao.RepartidorDAO;
import cl.duocuc.modelo.Pedido;
import cl.duocuc.modelo.Repartidor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class VentanaPrincipal extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> comboTipo;
    private JButton btnGuardarPedido;

    private JTextField txtNombreRepartidor;
    private JButton btnGuardarRepartidor;

    private JTable tablaPedidos;

    public VentanaPrincipal() {

        setTitle("SpeedFast");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        crearFormulario();
        crearTablaPedidos();

        cargarPedidosEnTabla();

    }

    private void crearFormulario() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2,5,5));

        panel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);

        panel.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"COMIDA", "ENCOMIENDA", "EXPRESS"});
        panel.add(comboTipo);

        btnGuardarPedido = new JButton("Guardar Pedido");
        panel.add(btnGuardarPedido);

        panel.add(new JLabel("Nombre Repartidor:"));
        txtNombreRepartidor = new JTextField();
        panel.add(txtNombreRepartidor);

        btnGuardarRepartidor = new JButton("Guardar Repartidor");
        panel.add(btnGuardarRepartidor);

        add(panel, BorderLayout.NORTH);

        btnGuardarPedido.addActionListener(e -> guardarPedido());
        btnGuardarRepartidor.addActionListener(e -> guardarRepartidor());
    }

    private void crearTablaPedidos() {

        tablaPedidos = new JTable();
        tablaPedidos.setModel(new DefaultTableModel(
                new Object[]{"ID","Dirección","Tipo","Estado"}, 0
        ));

        JScrollPane scroll = new JScrollPane(tablaPedidos);
        add(scroll, BorderLayout.CENTER);
    }

    private void crearTablaRepartidores() {

        tablaPedidos = new JTable();
        tablaPedidos.setModel(new DefaultTableModel(
                new Object[]{"ID","Nombre"}, 0
        ));

        JScrollPane scroll = new JScrollPane(tablaPedidos);
        add(scroll, BorderLayout.CENTER);
    }

    private void cargarRepartidoresEnTabla() {

        String sql = "SELECT * FROM repartidor";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel model =
                    (DefaultTableModel) tablaPedidos.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre")
                };
                model.addRow(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void guardarPedido() {

        String direccion = txtDireccion.getText();
        String tipo = comboTipo.getSelectedItem().toString();

        Pedido pedido = new Pedido(direccion, tipo, "PENDIENTE");

        PedidoDAO dao = new PedidoDAO();
        dao.guardar(pedido);

        JOptionPane.showMessageDialog(this,"Pedido guardado");

        cargarPedidosEnTabla();
        txtDireccion.setText("");
    }

    private void guardarRepartidor() {

        String nombre = txtNombreRepartidor.getText();

        Repartidor repartidor = new Repartidor(nombre);

        RepartidorDAO dao = new RepartidorDAO();
        dao.guardar(repartidor);

        JOptionPane.showMessageDialog(this,"Repartidor guardado");

        txtNombreRepartidor.setText("");
    }

    private void cargarPedidosEnTabla() {

        String sql = "SELECT * FROM pedido";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel model =
                    (DefaultTableModel) tablaPedidos.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("direccion"),
                        rs.getString("tipo"),
                        rs.getString("estado")
                };
                model.addRow(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarRepartidores() {

        String sql = "SELECT * FROM repartidor";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel model =
                    (DefaultTableModel) tablaPedidos.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre")
                };
                model.addRow(fila);
            }
        } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
    

