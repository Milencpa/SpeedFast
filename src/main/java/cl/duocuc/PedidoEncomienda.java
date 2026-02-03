package cl.duocuc;

public class PedidoEncomienda extends Pedido {
    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }
    @Override
    public double calcularTiempoEntrega() {
        return distanciaKm*3;
    }
}