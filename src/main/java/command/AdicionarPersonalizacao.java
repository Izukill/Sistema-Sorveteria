package command;

import decorator.Chantilly;
import decorator.Cobertura;
import decorator.Granulado;
import decorator.PedidoBase;
import model.Pedido;

public class AdicionarPersonalizacao implements Comando {

    private Pedido pedido;
    private PedidoBase produtoAnterior;
    private String tipoPersonalizacao;


    public AdicionarPersonalizacao(Pedido pedido, String tipoPersonalizacao) {
        this.pedido = pedido;
        this.tipoPersonalizacao = tipoPersonalizacao;
    }

    @Override
    public void executar() {

        produtoAnterior = pedido.getProduto();
        PedidoBase decorator;

        if ("cobertura".equalsIgnoreCase(tipoPersonalizacao)) {
            decorator = new Cobertura(produtoAnterior);
        } else if ("chantilly".equalsIgnoreCase(tipoPersonalizacao)) {
            decorator = new Chantilly(produtoAnterior);
        }else{
            decorator = new Granulado(produtoAnterior);
        }

        pedido.setProduto(decorator);



    }

    @Override
    public void desfazer() {

        if(this.produtoAnterior != null){
            pedido.setProduto(this.produtoAnterior);
        }

    }
}
