import command.FazerPedido;
import command.HistoricoComandos;
import decorator.*;
import model.Cliente;
import model.Pedido;
import singleton.Fila;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("João");

        PedidoBase pedido = new Pedido(cliente, "Sorvete de chocolate", 5.00f);

        pedido = new Granulado(pedido);
        pedido = new Chantilly(pedido);
        pedido = new Cobertura(pedido);

        FazerPedido fazerPedido = new FazerPedido(pedido);

        HistoricoComandos historico = new HistoricoComandos();

        historico.executar(fazerPedido);

        System.out.println("Fila atual de pedidos:");
        System.out.println(Fila.getInstancia().imprimir());

        System.out.println("\nDesfazendo último pedido...");
        historico.desfazer();

        System.out.println("Fila após desfazer:");
        System.out.println(Fila.getInstancia().imprimir());
    }
}
