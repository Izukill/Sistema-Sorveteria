package model;

import decorator.PedidoBase;
import state.EstadoPedido;
import state.PedidoRecebido;
import strategy.DescontoStrategy;
import strategy.SemDesconto;

public class Pedido implements PedidoBase {

    private String pedido;
    private Cliente cliente;
    private float precoOriginal;
    private EstadoPedido estado;
    private DescontoStrategy descontoStrategy;

    public Pedido(Cliente cliente, String pedido, float precoOriginal) {
        this.pedido = pedido;
        this.cliente = cliente;
        this.precoOriginal = precoOriginal;
        this.estado = new PedidoRecebido();
        this.descontoStrategy = new SemDesconto();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setDescontoStrategy(DescontoStrategy descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public DescontoStrategy getDescontoStrategy() {
        return descontoStrategy;
    }

    public float getPrecoOriginal() {
        return precoOriginal;
    }

    public void setPrecoOriginal(float precoOriginal) {
        this.precoOriginal = precoOriginal;
    }

    @Override
    public String getDescricao() {
        return pedido;
    }

    @Override
    public float getPreco() {
        return descontoStrategy.calcularDesconto(precoOriginal);
    }

    public String getDescricaoDesconto() {
        return descontoStrategy.getDescricao();
    }

    @Override
    public String toString() {
        return "Pedido de " + cliente.getNome() +
                " | Produto: " + getDescricao() +
                " | Preço com desconto: R$" + String.format("%.2f", getPreco()) +
                " | Estado: " + estado.getNome() +
                " | " + getDescricaoDesconto();
    }
}