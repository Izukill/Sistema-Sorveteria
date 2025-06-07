package command;

import model.Pedido;
import state.EstadoPedido;

import java.util.ArrayList;

public class AvancaEstado implements Comando {
    private Pedido pedido;
    private ArrayList<EstadoPedido> historicoPedido=new ArrayList<>();

    public AvancaEstado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        historicoPedido.add(pedido.getEstado());


        pedido.getEstado().proximoEstado(pedido);
    }

    @Override
    public void desfazer() {
        if(historicoPedido.isEmpty()){
            System.out.println("Não há como desfazer");
        }else{
            pedido.setEstado(historicoPedido.removeLast());
        }

    }



}
