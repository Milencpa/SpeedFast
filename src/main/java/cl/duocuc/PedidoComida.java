package cl.duocuc;

import java.util.ArrayList;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }
    @Override
    public double calcularTiempoEntrega() {
        return distanciaKm*2;
    }

}
