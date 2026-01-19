package cl.duocuc;

public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public double calcularTiempoEntrega() {
        // 10 min base; si distancia > 5 km se agregan 5 min extra
        double tiempo = 10.0;
        if (distanciaKm > 5.0) {
            tiempo += 5.0;
        }
        return tiempo;
    }
}