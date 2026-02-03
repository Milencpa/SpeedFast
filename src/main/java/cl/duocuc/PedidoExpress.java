package cl.duocuc;

public class PedidoExpress extends Pedido {
    public PedidoExpress (String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }
    @Override
    public double calcularTiempoEntrega() {
        return distanciaKm * 1.5;
    }
}