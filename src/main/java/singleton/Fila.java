package singleton;

import model.Cliente;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class Fila {
    private static Fila instancia;
    private static int Tamanho=0;

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

    public void remover(PedidoBase pedido) { fila.remove(pedido); } // eu add

    public void add(Pedido pedido){
        fila.add(pedido);
        Tamanho++;
    }

    public void remover(Pedido pedido){
        fila.remove(pedido);
        Tamanho--;
    }


    public Pedido primeiro(){

        try{
            return fila.getFirst();
        } catch (Exception e) {
            throw new RuntimeException("Não há mais pedidos");
        }

    }


    @Override
    public String toString() {
        if (fila.isEmpty()) {
            return "Fila vazia.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Fila de Pedidos:\n");

        for (int i = 0; i < fila.size(); i++) {
            Pedido pedido = fila.get(i);
            sb.append(i + 1).append(") ");
            sb.append("Cliente: ").append(pedido.getCliente().getNome()).append(" || ");
            sb.append("Sorvete: ").append(pedido.getGelado().getNome()).append(" || ");
            sb.append("Estado: ").append(pedido.getEstado().getNome()).append("\n");
        }

        return sb.toString();
    }


    public boolean vazia(){
        int j=0;
        for (int i = 0; i < Tamanho; i++) {
            j++;
        }
        if (j==0){
            return true;
        }else return false;
    }


}
