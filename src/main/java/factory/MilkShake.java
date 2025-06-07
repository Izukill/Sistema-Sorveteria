package factory;

public class MilkShake implements Gelados {
    @Override
    public String getNome() {
        return "MilkShake";
    }

    @Override
    public double getPreco() {
        return 10.0;
    }
}
