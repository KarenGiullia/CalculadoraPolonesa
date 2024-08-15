/**
 *
 * Classe responsável por converter a expressão polonesa inversa para a convencional.
 *
 */
public class Expressao {
    Pilha expressaoPolonesa = new Pilha();
    Celula celula;

    /**
     * Método que cria uma pilha que representa uma expressão aritmética em notação polonesa inversa (RPN)
     * e auxilia na conversão das expressões.
     *
     * @param expressao fila que contém a expressão aritmética a ser colocada em uma pilha.
     * @return pilha representando a expressão em notação polonesa reversa.
     */
    public Pilha criarPilha(Fila expressao) {
        Celula atual = expressao.frente.prox;
        //enquanto não chegar ao final
        while(atual != null){
            //coloca na pilha
            if (atual instanceof Variavel){
                Variavel variavel1 = new Variavel(((Variavel) atual).valor);
                expressaoPolonesa.empilhar(variavel1);
            } else {
                Operador operador = new Operador(((Operador) atual).valor);
                expressaoPolonesa.empilhar(operador);
            }
            atual = atual.prox; //anda na fila
        }
        return expressaoPolonesa;
    }

    /**
     * Método recursivo que converte uma pilha de elementos em notação polonesa reversa (RPN)
     * para uma expressão convencional.
     *
     * @param expressaoPolonesa pilha que contém a expressão em notação polonesa reversa.
     * @return string representando a expressão aritmética em notação infixa.
     */
    public String criarExpressao(Pilha expressaoPolonesa) {
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