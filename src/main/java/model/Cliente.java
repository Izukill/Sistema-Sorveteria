package model;

import observer.Assinante;

public class Cliente implements Assinante {
    private String nome;
    private long Id;


    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, int id) {
        this.nome = nome;
        Id = id;
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente = "+nome;
    }

    @Override
    public void atualizar(String mensagem) {

        System.out.println("O Pedido do Cliente: " + nome + " está" + mensagem);
    }
}
