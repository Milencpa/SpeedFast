package cl.duocuc;


public abstract class Pedido {
    protected String idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }
    public abstract double calcularTiempoEntrega();

    public void mostrarResumen() {
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Dirección de Entrega: " + direccionEntrega);
        System.out.println("Distancia (km): " + distanciaKm);
        System.out.println("Tiempo Entrega: " + calcularTiempoEntrega());
    }
    public void despachar() {
        System.out.println("Pedido " + idPedido + " despachado.");
    }

    public void cancelar() {
        System.out.println("Pedido " + idPedido + " cancelado.");
    }

    public void rastrear () {
        System.out.println("Rastreando pedido " + idPedido + "...");
    }

    public String getIdPedido() {
        return idPedido;
    }
}