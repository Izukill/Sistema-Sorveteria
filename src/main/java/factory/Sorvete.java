package factory;

import decorator.PedidoBase;

public class Sorvete implements PedidoBase {
    @Override
    public String getDescricao() {
        return "Sorvete";
    }

    @Override
    public float getPreco() {
        return 6.50f;
    }
}
