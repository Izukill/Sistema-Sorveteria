package decorator;

public class Granulado extends AdicionalDecorator {
    public Granulado(PedidoBase pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + " + Granulado";
    }

    @Override
    public float getPreco() {
        return pedidoDecorado.getPreco() + 0.50f;
    }

    @Override
    public void setPreco(float valor) {
        pedidoDecorado.setPreco(valor);
    }
}
