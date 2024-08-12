import java.util.Vector;

public class Expressao {
    Fila expressaoTradicional =new Fila();
    Pilha expressaoPolonesa = new Pilha();
    Celula celula;
    public Pilha criarPilha(Vector<String> expressao){

        for(String caracter: expressao){
            if(caracter.equals("-") || caracter.equals("+") || caracter.equals("/") || caracter.equals("*")){
                celula = new Operador(caracter);
            }else{
                celula = new Variavel(Double.parseDouble(caracter));
            }
            expressaoPolonesa.empilhar(celula); //coloca na pilha
        }

        return expressaoPolonesa;
    }

    public String criarExpressao (Pilha expressaoPolonesa) {
        StringBuilder expressao = new StringBuilder();
        if ((celula = expressaoPolonesa.desempilhar()) != null) {
            if (celula instanceof Operador) {
                // faz duas chamadas recursivas para preencher a operação à esquerda e à direita
                // constrói a expressão de trás para frente (invertido)
                String operador = ((Operador) celula).valor;
                expressao.insert(0, ')');
                expressao.insert(0, criarExpressao(expressaoPolonesa));
                expressao.insert(0, operador);
                expressao.insert(0, criarExpressao(expressaoPolonesa));
                expressao.insert(0,'(');
            } else if (celula instanceof Variavel) {
                expressao.append(((Variavel) celula).valor);
            }
        }
        return expressao.toString();
    }
}
