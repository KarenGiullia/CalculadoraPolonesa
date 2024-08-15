/**
 * Classe principal do programa, responsável por fazer a leitura de um arquivo de expressões,
 * calcular os resultados das expressões e exibir os resultados.
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        // Cria instâncias dos componentes necessários
        Calculadora calculadora = new Calculadora();
        LeitorArquivo leitorArquivo = new LeitorArquivo("expressao.txt");
        Expressao expressao = new Expressao();
        Celula celula;
        double resultado;
        Fila fila;
        Pilha pilha;

        //Lê e processa cada linha do arquivo até o final
        while ((fila = leitorArquivo.fatiarLinha()) != null) {
            //Calcula o resultado da expressão
            resultado = calculadora.calcular(fila);
            //Cria uma pilha a partir da fila e monta a expressão
            pilha = expressao.criarPilha(fila);
            //Monta a expressão e exibe com seu resultado
            System.out.print(expressao.criarExpressao(pilha));
            System.out.println(" = " + resultado);
        }
    }
}
