package cl.duocuc;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pedido p1 = new PedidoComida("PC001", "Calle Falsa 123", 5.0);
        Pedido p2 = new PedidoEncomienda("PE001", "Avenida Siempre Viva) 742", 10.0);
        Pedido p3 = new PedidoExpress("PX001", "Boulevard de los Sueños Rotos 456", 8.0);
        Pedido p4 = new PedidoComida("PC002", "Calle Luna 789", 3.5);
        Pedido p5 = new PedidoExpress("PX002", "Avenida del Sol 321", 12.0);
        Pedido p6 = new PedidoEncomienda("PE002", "Calle Estrella 654", 7.0);

        List<Pedido> pedidosRepartidor1 = new ArrayList<Pedido>();
        List<Pedido> pedidosRepartidor2 = new ArrayList<Pedido>();
        List<Pedido> pedidosRepartidor3 = new ArrayList<Pedido>();

        Repartidor r1 = new Repartidor ("Juan", p1);
        Repartidor r2 = new Repartidor ("Ana", p2);
        Repartidor r3 = new Repartidor ("Luis", p3);

        runnableDelivery(r1);
        runnableDelivery(r2);
        runnableDelivery(r3);

    }

    private static void runnableDelivery(Repartidor r1) {
        Thread t1 = new Thread(r1);
        t1.start();
    }
}