package cl.duocuc;


import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {
    private Queue<Pedido> pedidosPendientes;

    public ZonaDeCarga() {
        this.pedidosPendientes = new LinkedList<>();
    }

    // Método sincronizado para agregar pedidos
    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("✓ Pedido #" + p.getId() + " agregado a la zona de carga - Destino: " + p.getDireccionEntrega());
        notifyAll(); // Notifica a los hilos en espera que hay un nuevo pedido
    }

    // Método sincronizado para retirar pedidos
    public synchronized Pedido retirarPedido() {
        // Espera mientras no haya pedidos disponibles
        while (pedidosPendientes.isEmpty()) {
            try {
                wait(); // Espera a que lleguen pedidos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        // Retira el pedido de la cola
        Pedido pedido = pedidosPendientes.poll();
        return pedido;
    }

    // Método para verificar si quedan pedidos
    public synchronized boolean hayPedidos() {
        return !pedidosPendientes.isEmpty();
    }

    // Método para obtener la cantidad de pedidos pendientes
    public synchronized int cantidadPedidos() {
        return pedidosPendientes.size();
    }
}
