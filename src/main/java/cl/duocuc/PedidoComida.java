package cl.duocuc;

import java.util.ArrayList;

public class PedidoComida extends Pedido
        implements Rastreable, Cancelable, Despachable {
        private ArrayList<String> historial = new ArrayList<>();

        public PedidoComida (String idPedido, String cliente) {
            super(idPedido, cliente);
            historial.add("Pedido creado.");
        }

        //Sobreescritura
        @Override
        public void asignarRepartidor(String nombreRepartidor) {
            this.repartidor = "Repartidor de comida";
            historial.add("Repartidor de comida asignado: " + nombreRepartidor);
        }

        @Override
        public double calcularTiempoEntrega() {
            return 30.0; // Tiempo fijo de 30 minutos
        }

        @Override
        public void despachar() {
            historial.add("Pedido " + idPedido + " despachado.");
            System.out.println("Despachando pedido de comida ID: " + idPedido);

        }
        @Override
        public void verHistorial() {
            System.out.println("Historial de estados para el pedido ID: " + idPedido);
            for (String estado : historial) {
                System.out.println("- " + estado);
            }
        }

    @Override
    public void cancelar() {
            historial.add("Pedido " + idPedido + " cancelado.");

    }
}