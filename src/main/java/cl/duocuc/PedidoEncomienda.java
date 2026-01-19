package cl.duocuc;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public double calcularTiempoEntrega() {
        // 20 min base + 1.5 min por km, ajustar a entero (se redondea al entero más cercano)
        double tiempo = 20.0 + 1.5 * distanciaKm;
        return (double) Math.round(tiempo);
    }
}