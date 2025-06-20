package factory;

import decorator.PedidoBase;

public class MilkShakeFactory extends SorveteriaFactory {
    @Override
    public PedidoBase criarGelado() {
        return new MilkShake();
    }
}
