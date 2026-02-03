package cl.duocuc;

public class Repartidor implements Runnable{
    private String nombre;
    private Pedido pedido;

    public Repartidor(String nombre, Pedido pedido) {
        this.nombre = nombre;
        this.pedido = pedido;
    }

    @Override
    public void run() {
        System.out.println("Repartidor " + nombre + " ha comenzado a entregar el pedido " + pedido.getIdPedido());
        double tiempoEntrega = pedido.calcularTiempoEntrega();
        try {
            Thread.sleep((long) (tiempoEntrega * 1000)); // Simula el tiempo de entrega
        } catch (InterruptedException e) {
            e.printStackTrace();

}
        System.out.println("Repartidor " + nombre + " ha entregado el pedido " + pedido.getIdPedido());
    }
}