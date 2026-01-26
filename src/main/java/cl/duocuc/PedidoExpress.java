package cl.duocuc;

public class PedidoExpress extends Pedido
    implements Despachable, Cancelable {

        public PedidoExpress(String idPedido, String cliente) {
            super(idPedido, cliente);
        }
        @Override
        public void asignarRepartidor () {
            this.repartidor = "Repartidor Express";
        }
        @Override
        public double calcularTiempoEntrega () {
            return 15.0; // Tiempo fijo de 15 minutos
        }
        @Override
        public void despachar () {
            System.out.println("Despachando pedido express ID: " + idPedido);
        }
        @Override
        public void cancelar () {
            super.cancelar();
            System.out.println("Cancelando pedido express");
    }
}