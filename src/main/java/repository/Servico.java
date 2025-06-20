package repository;


import model.Cliente;
import model.Pedido;

public class Servico {

    private PedidoBd pedidoRepository;
    private ClienteBd clienteRepository;

    public Servico(PedidoBd pedidoRepository, ClienteBd clienteRepositor) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;

    }

    public void Salvar(Cliente cliente, Pedido pedido){

        clienteRepository.adicionarCliente(cliente);

        pedidoRepository.adicionarPedido(pedido);
    }

    public void atualizarPedido(Pedido pedido){

        pedidoRepository.atualizarPedido(pedido);
    }






}
