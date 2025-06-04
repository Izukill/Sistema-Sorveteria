package command;

import model.Pedido;
import state.EstadoPedido;

public class AvancaEstado implements Comando {
    private Pedido pedido;
    private EstadoPedido estadoAnteior;

    public AvancaEstado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        estadoAnteior=pedido.getEstado();
        pedido.getEstado().proximoEstado(pedido);
    }

    @Override
    public void desfazer() {
        if(estadoAnteior==null){
            System.out.println("Não há como desfazer");
        }else{
            pedido.setEstado(estadoAnteior);
        }

    }

    public EstadoPedido getEstadoAnteior() {
        return estadoAnteior;
    }
}
