package cl.duocuc;

public class Repartidor implements Runnable{
    private String nombre;
    private ZonaDeCarga zonaDeCarga;
    private int pedidosEntregados;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
        this.pedidosEntregados = 0;
    }

    @Override
    public void run() {
        System.out.println(nombre + " ya va en camino a entregar pedidos.");

        while (true) {
            // Intenta retirar un pedido
            Pedido pedido = zonaDeCarga.retirarPedido();

            // Si no hay más pedidos, termina
            if (pedido == null) {
                break;
            }

            try {
                // Cambia el estado a EN_REPARTO
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                System.out.println(nombre + " retiró el Pedido #" + pedido.getId() +
                        " - Estado: " + pedido.getEstado() +
                        " - Destino: " + pedido.getDireccionEntrega());

                // Simula el tiempo de entrega (entre 2 y 4 segundos)
                int tiempoEntrega = 2000 + (int)(Math.random() * 2000);
                Thread.sleep(tiempoEntrega);

                // Cambia el estado a ENTREGADO
                pedido.setEstado(EstadoPedido.ENTREGADO);
                pedidosEntregados++;
                System.out.println(nombre + " entregó el Pedido #" + pedido.getId() +
                        " - Estado: " + pedido.getEstado() +
                        " - Tiempo: " + (tiempoEntrega/1000.0) + "s");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " fue interrumpido durante la entrega");
                break;
            }
        }

        System.out.println(nombre + " ha finalizado su jornada - Total entregados: " + pedidosEntregados);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPedidosEntregados() {
        return pedidosEntregados;
    }
}