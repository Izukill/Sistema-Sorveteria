package model;

import decorator.PedidoBase;
import observer.Observer;
import state.EstadoPedido;

public class Pedido{


    private Cliente cliente;
    private EstadoPedido estado;

    private PedidoBase produto;


    private long id;
    private Observer observer=new Observer();

    public Pedido(Cliente cliente, PedidoBase produto) {
        this.produto=produto;
        this.cliente=cliente;
    }


    public PedidoBase getProduto() {
        return produto;
    }

    public void setProduto(PedidoBase produto) {
        this.produto = produto;
    }

    public float getPreco(){
        return produto.getPreco();
    }

    public String getDescricao(){
        return produto.getDescricao();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        notificarCliente(estado.getNome());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarClienteObserver(){
        observer.adicionarAssinante(cliente);
    }

    public void notificarCliente(String mensagem){
        observer.notificar(mensagem);
    }




}
