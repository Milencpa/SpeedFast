package cl.duocuc;

public class Main {
    public static void main(String[] args) {
        PedidoComida pc = new PedidoComida("C001", "Av. Brasil 123", 3.5);
        PedidoEncomienda pe = new PedidoEncomienda("E001", "Calle Zuleta 456", 12.5);
        PedidoExpress px = new PedidoExpress("X001", "Pasaje Hilda Mora 789", 6.2);

        System.out.println("Resumen y tiempos estimados:\n");

        pc.mostrarResumen();
        double tiempoPc = pc.calcularTiempoEntrega();
        System.out.println("Tiempo estimado (Pedido Comida): " + (int)Math.round(tiempoPc) + " minutos\n");

        pe.mostrarResumen();
        double tiempoPe = pe.calcularTiempoEntrega();
        System.out.println("Tiempo estimado (Pedido Encomienda): " + (int)tiempoPe + " minutos\n");

        px.mostrarResumen();
        double tiempoPx = px.calcularTiempoEntrega();
        System.out.println("Tiempo estimado (Pedido Express): " + (int)Math.round(tiempoPx) + " minutos\n");

    }
}