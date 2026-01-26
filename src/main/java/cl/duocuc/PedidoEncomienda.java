package cl.duocuc;

public class PedidoEncomienda extends Pedido
    implements Despachable, Cancelable {

        public PedidoEncomienda(String idPedido, String cliente) {
            super(idPedido, cliente);
        }
        @Override
        public void asignarRepartidor(String nombreRepartidor){
            this.repartidor = nombreRepartidor;
        }
        @Override
        public double calcularTiempoEntrega() {
            return 60;
        }
        @Override
        public void despachar() {
            System.out.println("Despachando encomienda ID: " + idPedido);
        }
        @Override
        public void cancelar() {
            super.cancelar();
            System.out.println("Cancelando encomienda");
    }
}