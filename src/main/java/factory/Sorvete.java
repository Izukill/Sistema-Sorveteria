package factory;

public class Sorvete implements Gelados {
    @Override
    public String getNome() {
        return "Sorvete";
    }

    @Override
    public double getPreco() {
        return 6.50;
    }
}
