package model;

import state.EstadoPedido;
import state.PedidoRecebido;

public class Pedido {

    private String descricao;
    private Cliente cliente;
    private float preco;
    private EstadoPedido estado;
    private long id;

    public Pedido(Cliente cliente, String Descricao, float preco) {
        this.descricao = Descricao;
        this.preco = preco;
        this.cliente=cliente;
        this.estado= new PedidoRecebido();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
