package facade;


import model.Pedido;
import strategy.DescontoStrategy;

public class PagamentoFacade {

    private DescontoStrategy strategy;

    public PagamentoFacade(DescontoStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DescontoStrategy strategy) {
        this.strategy = strategy;
    }

    public float pagamento(Pedido pedido){
        float precoOriginal= pedido.getPreco();
        return strategy.calcularDesconto(precoOriginal);

    }

    public void notaPagamento(Pedido pedido){

        float precoOriginal= pedido.getPreco();
        float precoDesconto= strategy.calcularDesconto(precoOriginal);


        System.out.println("----RESUMO DO PAGAMENTO----");
        System.out.println("Cliente:" + pedido.getCliente().getNome());
        System.out.println("Produto:" + pedido.getProduto().getDescricao());
        System.out.println("Preço original: R$" + precoOriginal);
        System.out.println("Desconto aplicado:" + strategy.getDescricao());
        System.out.println("Preço final: R$" + precoDesconto);
        System.out.println("-----------------------------");
    }

}



