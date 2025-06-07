package model;

import factory.Gelados;
import observer.Notificador;
import observer.Observer;
import state.EstadoPedido;
import state.PedidoRecebido;

public class Pedido{

    private Gelados sorvete;
    private Cliente cliente;
    private float preco;
    private EstadoPedido estado;
    private long id;
    private Observer observer=new Observer();

    public Pedido(Cliente cliente, Gelados sorvete) {
        this.sorvete = sorvete;
        this.cliente=cliente;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gelados getGelado() {
        return sorvete;
    }

    public void setGelado(Gelados sorvete) {
        this.sorvete = sorvete;
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
