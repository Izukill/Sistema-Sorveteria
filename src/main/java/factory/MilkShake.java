package factory;

import decorator.PedidoBase;

public class MilkShake implements PedidoBase{
    @Override
    public String getDescricao() {
        return "MilkShake";
    }

    @Override
    public float getPreco() {
        return 10.0f;
    }

    public void setPreco(float valor){
        return;
    }


}
