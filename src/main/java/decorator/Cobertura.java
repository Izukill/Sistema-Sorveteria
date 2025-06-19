package decorator;

public class Cobertura extends AdicionalDecorator {
    public Cobertura(PedidoBase pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + " + Cobertura";
    }

    @Override
    public float getPreco() {
        return pedidoDecorado.getPreco() + 1.50f;
    }
}
