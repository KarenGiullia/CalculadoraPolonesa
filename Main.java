import java.io.FileNotFoundException;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws Exception {
        Calculadora calculadora = new Calculadora();
        LeitorArquivo leitorArquivo = new LeitorArquivo("M:\\Usuarios\\0079504\\Downloads\\CalculadoraPolonesa-main\\CalculadoraPolonesa-main\\expressao.txt");
        Vector<String> linha;

        double resultado;

        while ((linha = leitorArquivo.fatiarLinha()) != null){

            resultado = calculadora.calcular(linha);
            System.out.println(resultado);
        }



    }
}