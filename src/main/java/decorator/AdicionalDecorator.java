package decorator;

public abstract class AdicionalDecorator implements PedidoBase {
    protected PedidoBase pedidoDecorado;

    public AdicionalDecorator(PedidoBase pedidoDecorado) {
        this.pedidoDecorado = pedidoDecorado;
    }

    @Override
    public float getPreco() {
        return pedidoDecorado.getPreco();
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao();
    }
}
