package cl.duocuc;

public abstract class Pedido {
    protected String idPedido;
    protected String cliente;
    protected String repartidor;
    protected boolean cancelado;

    public Pedido(String idPedido, String cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.repartidor = "No asignado";
        this.cancelado = false;
    }

    // Método para cancelar el pedido
    public void cancelar() {
        this.cancelado = true;
        System.out.println("El pedido ID: " + idPedido + " ha sido cancelado.");
    }

    //Polimorfismo: sobrecarga de métodos
    public void asignarRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }
    public void asignarRepartidor() {
        this.repartidor = "Repartidor por defecto";
    }

    public void mostrarResumen() {
        System.out.println("\nID Pedido: " + idPedido);
        System.out.println("Cliente: " + cliente);
        System.out.println("Repartidor: " + repartidor);
        System.out.println("Estado: " + (cancelado ? "Cancelado" : "Activo"));
    }

    // Método abstracto para calcular el tiempo de entrega
    public abstract double calcularTiempoEntrega();
}