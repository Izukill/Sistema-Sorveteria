package factory;

import decorator.PedidoBase;

public class PicoleFactory extends SorveteriaFactory {

    @Override
    public PedidoBase criarGelado() {
        return new Picole();
    }
}
