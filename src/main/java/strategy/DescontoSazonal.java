package strategy;

public class DescontoSazonal implements DescontoStrategy {
    @Override
    public float calcularDesconto(float precoOriginal) {
        return precoOriginal * 0.75f; //
    }

    @Override
    public String getDescricao() {
        return "Desconto sazonal de 25%";
    }
}
