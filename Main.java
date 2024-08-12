import java.io.FileNotFoundException;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws Exception {
        Calculadora calculadora = new Calculadora();
        LeitorArquivo leitorArquivo = new LeitorArquivo("expressao.txt");
        Vector<String> linha;
        Expressao expressao = new Expressao();

        double resultado;

        while ((linha = leitorArquivo.fatiarLinha()) != null){
            resultado = calculadora.calcular(linha);
            Pilha pilha = expressao.criarPilha(linha);
            System.out.print(expressao.criarExpressao(pilha));
            System.out.println(" = " + resultado);
        }

    }
}