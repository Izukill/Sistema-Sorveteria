package observer;

import model.Cliente;

public interface Notificador {

    public void adicionarAssinante(Cliente cliente);
    public void removerAssinante(Cliente cliente);
    public void notificar(String mensagem);
}
