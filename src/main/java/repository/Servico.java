package repository;


import model.Cliente;
import model.Pedido;

public class Servico {

    private PedidoBd pedidoRepository;
    private ClienteBd clienteRepository;

    public Servico(PedidoBd pedidoRepository, ClienteBd clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;

    }

    public void salvarCliente(Cliente cliente){

        clienteRepository.adicionarCliente(cliente);

    }

    public void salvarPedido(Pedido pedido){

        pedidoRepository.adicionarPedido(pedido);
    }



    public void atualizarPedido(Pedido pedido){

        pedidoRepository.atualizarPedido(pedido);
    }






}
