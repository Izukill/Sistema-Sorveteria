package command;

import model.Pedido;
import state.PedidoCancelado;

public class FazerPedido implements Comando{

    private Pedido pedido;

    @Override
    public void executar() {

        System.out.println("Pedido realizado");
        //Implementar a criação do pedido
    }

    @Override
    public void desfazer() {
        pedido.setEstado(new PedidoCancelado());
    }
}
