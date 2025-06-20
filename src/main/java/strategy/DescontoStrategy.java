package strategy;

public interface DescontoStrategy {
    float calcularDesconto(float precoOriginal);
    String getDescricao();
}
