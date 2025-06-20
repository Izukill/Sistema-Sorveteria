package strategy;

public class DescontoClienteFrequente implements DescontoStrategy {
    @Override
    public float calcularDesconto(float precoOriginal) {
        return precoOriginal * 0.90f;
    }

    @Override
    public String getDescricao() {
        return "Desconto de 10% para cliente frequente";
    }
}
