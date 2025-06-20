import command.*;
import decorator.*;
import model.*;
import singleton.Fila;
import strategy.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João");

        Pedido pedido = new Pedido(cliente, "Sorvete de chocolate", 5.00f);

        pedido.setDescontoStrategy(new DescontoClienteFrequente());

        PedidoBase pedidoDecorado = new Granulado(pedido);
        pedidoDecorado = new Chantilly(pedidoDecorado);
        pedidoDecorado = new Cobertura(pedidoDecorado);

        Comando fazerPedido = new FazerPedido(pedido);

        HistoricoComandos historico = new HistoricoComandos();
        historico.executar(fazerPedido);

        System.out.println("\n=== Fila de Pedidos ===");
        System.out.println(Fila.getInstancia().imprimir());

        System.out.println("\nDesfazendo pedido...");
        historico.desfazer();

        System.out.println("\n=== Fila após desfazer ===");
        System.out.println(Fila.getInstancia().imprimir());
    }
}
