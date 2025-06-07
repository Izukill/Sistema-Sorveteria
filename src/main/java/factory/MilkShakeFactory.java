package factory;

public class MilkShakeFactory extends SorveteriaFactory {
    @Override
    public Gelados criarGelado() {
        return new MilkShake();
    }
}
