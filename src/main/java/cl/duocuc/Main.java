package cl.duocuc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("..:: SISTEMA DE ENTREGAS SPEEDFAST ::..\n");

        // Instancia la zona de carga compartida
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Agregar pedidos al sistema
        System.out.println("--- Cargando pedidos en el sistema ---");
        zonaDeCarga.agregarPedido(new Pedido(1, "Av. Brasil 123, Costa Laguna"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Calle Los Aromos 567, Coloso"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Pasaje San Martín 890, Antofagasta Centro"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Av. Apoquindo 2345, Coviefi"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Calle María Riquelme 678, Antofagasta Sur"));
        zonaDeCarga.agregarPedido(new Pedido(6, "Av. Grecia 1111, Antofagasta Norte"));
        zonaDeCarga.agregarPedido(new Pedido(7, "Calle Merced 333, Jardines del sur"));

        System.out.println("\n--- Iniciando repartidores ---\n");

        // Crear lista de repartidores
        List<Repartidor> repartidores = new ArrayList<>();
        repartidores.add(new Repartidor("Repartidor Carlos", zonaDeCarga));
        repartidores.add(new Repartidor("Repartidor María", zonaDeCarga));
        repartidores.add(new Repartidor("Repartidor Juan", zonaDeCarga));

        // Opción 1: Usando ExecutorService (Recomendado)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Repartidor repartidor : repartidores) {
            executor.execute(repartidor);
        }

        // No se aceptarn más tareas
        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("\n=== RESUMEN FINAL ===");
                System.out.println("✓ Todos los pedidos han sido entregados correctamente");
                System.out.println("\nEstadísticas por repartidor:");
                for (Repartidor rep : repartidores) {
                    System.out.println("  • " + rep.getNombre() + ": " + rep.getPedidosEntregados() + " pedidos entregados");
                }
            } else {
                System.out.println("El tiempo de espera excedió el límite");
            }
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido");
            executor.shutdownNow();
        }

        System.out.println("\n=== FIN DEL SISTEMA ===");
    }
}