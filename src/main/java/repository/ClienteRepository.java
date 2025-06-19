package repository;

import model.Cliente;

public interface ClienteRepository {
    void adicionarCliente(Cliente cliente);
    void lerCliente();
}
