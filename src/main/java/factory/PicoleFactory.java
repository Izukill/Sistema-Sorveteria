package factory;

public class PicoleFactory extends SorveteriaFactory {

    @Override
    public Gelados criarGelado() {
        return new Picole();
    }
}
