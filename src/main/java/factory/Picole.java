package factory;

import decorator.PedidoBase;

public class Picole implements PedidoBase {
    @Override
    public String getDescricao() {
        return "Picolé";
    }

    @Override
    public float getPreco() {
        return 5.0f;
    }
}
