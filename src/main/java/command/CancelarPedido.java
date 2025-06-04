package command;

import model.Pedido;
import state.PedidoCancelado;

public class CancelarPedido implements Comando{

    private Pedido pedido;
    @Override
    public void executar() {
        pedido.setEstado(new PedidoCancelado());
    }

    @Override
    public void desfazer() {


    }
}
