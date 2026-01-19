package cl.duocuc;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public double calcularTiempoEntrega() {
        // 15 min base + 2 min por km
        return 15.0 + 2.0 * distanciaKm;
    }
}