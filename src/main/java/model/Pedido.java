package model;

import state.EstadoPedido;
import state.PedidoCancelado;
import state.PedidoRecebido;

public class Pedido {

    private String pedido;
    private Cliente cliente;
    private float preco;
    private EstadoPedido estado;

    public Pedido(Cliente cliente, String pedido, float preco) {
        this.pedido = pedido;
        this.preco = preco;
        this.cliente=cliente;
        this.estado= new PedidoRecebido();
    }



    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
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

}
