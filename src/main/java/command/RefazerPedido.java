package command;

import model.Pedido;
import state.PedidoCancelado;

public class RefazerPedido implements Comando{

    private Pedido pedido;


    @Override
    public void executar() {

    }

    @Override
    public void desfazer() {
        pedido.setEstado(new PedidoCancelado());
    }
}
