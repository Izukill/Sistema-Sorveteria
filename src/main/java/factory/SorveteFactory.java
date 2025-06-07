package factory;

public class SorveteFactory extends SorveteriaFactory {
    @Override
    public Gelados criarGelado() {
        return new Sorvete();
    }
}
