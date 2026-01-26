package cl.duocuc;

public class Main {
    public static void main(String[] args) {

        //Crear pedidos
        PedidoComida pc = new PedidoComida("35234", "Carlos");
        PedidoEncomienda pe = new PedidoEncomienda("34353", "Ana");
        PedidoExpress px = new PedidoExpress("98765", "Luis");

        //Asignar repartidores
        System.out.println("\n======= ASIGNANDO REPARTIDORES =======");
        pc.asignarRepartidor("José");
        pe.asignarRepartidor("Luciano");
        px.asignarRepartidor("Luisa");
        System.out.println("Repartidores asignados con éxito.");

        //Mostrar resumen
        System.out.println("\n======= RESUMEN DE PEDIDOS =======");
        pc.mostrarResumen();
        System.out.println("Tiempo de entrega estimado: " + pc.calcularTiempoEntrega() + " minutos");

        pe.mostrarResumen();
        System.out.println("Tiempo de entrega estimado: " + pe.calcularTiempoEntrega() + " minutos");

        px.mostrarResumen();
        System.out.println("Tiempo de entrega estimado: " + px.calcularTiempoEntrega() + " minutos");

        //Operaciones
        System.out.println("\n======= OPERACIONES =======");
        pc.despachar();
        pe.cancelar();
        px.despachar();

        //historial de pedidos
        System.out.println("\n======= HISTORIAL DE PEDIDOS DE COMIDA =======");
        pc.verHistorial();

        //Mostrar el estado final de los pedidos
        System.out.println("\n======= ESTADO FINAL DE LOS PEDIDOS =======");
        pc.mostrarResumen();
        pe.mostrarResumen();
        px.mostrarResumen();

    }
}