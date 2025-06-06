package repository;

import model.Cliente;

public interface ClienteRepository {
    long adicionarCliente(Cliente cliente);
    void lerCliente();
}
