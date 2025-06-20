package decorator;

public class Chantilly extends AdicionalDecorator {
    public Chantilly(PedidoBase pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + " + Chantilly";
    }

    @Override
    public float getPreco() {
        return pedidoDecorado.getPreco() + 2.25f;
    }

    @Override
    public void setPreco(float valor) {
        pedidoDecorado.setPreco(valor);
    }
}
