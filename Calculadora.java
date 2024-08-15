/**
 *
 * Classe responsável por calcular expressões aritméticas em forma de notação polonesa inversa.
 *
 */
public class Calculadora {

    Pilha pilha = new Pilha();
    Celula variavel;

    /**
     * Método para calcular o resultado de uma expressão aritmética representada por uma fila de objetos Celula.
     * A expressão deve estar em notação polonesa inversa (RPN).
     *
     * @param expressao fila que contém a expressão aritmética a ser calculada.
     * @return O resultado da expressão aritmética como um valor double.
     * @throws Exception Se ocorrer algum erro durante o cálculo, como uma operação inválida.
     */
    public double calcular(Fila expressao) throws Exception {
        Celula atual = expressao.frente.prox;
        //enquanto não chegar ao final
        while(atual != null){
            if (atual instanceof Variavel){  //se for variavel
                //empilha na pilha
                Variavel variavel1 = new Variavel(((Variavel) atual).valor);
                pilha.empilhar(variavel1);

            } else {  //se for sinal

                //desempilha valor1
                variavel = pilha.desempilhar();
                double valor1 = (double) variavel.getValor();

                //desempilha valor2
                variavel = pilha.desempilhar();
                double valor2 = (double) variavel.getValor();

                //faz a conta
                if (atual.getValor().equals("-")) {
                    double resultado = valor2 - valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                } else if (atual.getValor().equals("+")) {
                    double resultado = valor2 + valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                } else if (atual.getValor().equals("/")) {
                    double resultado = valor2 / valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                } else if (atual.getValor().equals("*")) {
                    double resultado = valor2 * valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                }
            }
            atual = atual.prox; //anda na fila
        }

        //desempilha o ultimo
        variavel = pilha.desempilhar();
        return (double) variavel.getValor();    //retorna o total
    }
}