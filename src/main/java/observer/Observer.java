package observer;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Observer implements Notificador{

    private List<Cliente> observers=new ArrayList<>();

    @Override
    public void adicionarAssinante(Cliente cliente) {
        observers.add(cliente);

    }

    @Override
    public void removerAssinante(Cliente cliente) {
        observers.remove(cliente);

    }

    @Override
    public void notificar(String mensagem) {
        for(Cliente c : observers){
            c.atualizar(mensagem);
        }

    }
}
