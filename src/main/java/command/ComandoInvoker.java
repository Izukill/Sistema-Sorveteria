package command;

import java.util.Stack;

public class ComandoInvoker {
    private Stack<Comando> historico=new Stack<>();

    public void executar(Comando comando){
        comando.executar();
        historico.push(comando);
    }

    public void desfazer(){
        if(historico.isEmpty()){
            System.out.println("Não há nada para desfazer");
        }else{
            Comando comando= historico.pop();
            comando.desfazer();
        }
    }
}
