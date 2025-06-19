package factory;

import decorator.PedidoBase;

public class SorveteFactory extends SorveteriaFactory {
    @Override
    public PedidoBase criarGelado() {
        return new Sorvete();
    }
}
