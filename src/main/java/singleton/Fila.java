package singleton;

import model.Cliente;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class Fila {
    private static Fila instancia;

    List<Pedido> fila= new ArrayList<>();


    private Fila() {
        this.fila= new ArrayList<>();


    }

    public static Fila getInstancia(){
        if(instancia == null){
            instancia = new Fila();
        }

        return instancia;

    }


    public void add(Pedido pedido){
        fila.add(pedido);
    }

    public Pedido atender(){
        return fila.removeFirst();
    }


    public String imprimir(){
        return fila.toString();
    }
}
