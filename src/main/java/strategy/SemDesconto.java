package strategy;

public class SemDesconto implements DescontoStrategy {
    @Override
    public float calcularDesconto(float precoOriginal) {
        return precoOriginal;
    }

    @Override
    public String getDescricao() {
        return "Sem desconto aplicado";
    }
}
