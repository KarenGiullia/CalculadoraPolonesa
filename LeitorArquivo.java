import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Vector;

public class LeitorArquivo {
    private String diretorioArquivo;
    //private Ferramentas ferramentas;
    private int tamanhoLinha;
    BufferedReader entradaDeDados;

    /**
     * Construtor da classe LeitorArquivo.
     * @param diretorioArquivo String contendo o diretório do arquivo da base de dados.
     *
     */
    public LeitorArquivo(String diretorioArquivo) throws FileNotFoundException {

        this.diretorioArquivo = diretorioArquivo;
        this.entradaDeDados = new BufferedReader(new FileReader(diretorioArquivo));
        //this.ferramentas = new Ferramentas();
        //this.tamanhoLinha = tamanhoLinha;
    }

    public String getDiretorioArquivo() {
        return diretorioArquivo;
    }

    public void setDiretorioArquivo(String diretorioArquivo) {
        this.diretorioArquivo = diretorioArquivo;
    }
    /**
     * Método que fatia as informações de uma linha da base de dados entre vírgulas e as coloca num vetor.
     * @return retorna o vetor do tipo String, ou null caso a linha esteja vazia.
     */
    public Vector<String> fatiarLinha() {
        Vector<String> linhaFatiada = new Vector<>();
        try {
            String linha = entradaDeDados.readLine();
            if (linha != null) {
                String[] linhaVetor = linha.split(" ");
                linhaFatiada.addAll(Arrays.asList(linhaVetor));
            } else {
                linhaFatiada = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhaFatiada;
    }
    /**
     * Chama o método fatiarlinha() para obter o vetor com as informações separadas e cria um objeto Tweet com elas.
     *
     * @return Uma instância da classe Tweet, ou null caso o vetor também esteja vazio.
     */
//    public Tweet proximoTweet() {
//        String[] linhaFatiada = fatiarLinha();
//        if (linhaFatiada == null) {
//            return null;
//        }
//        return new Tweet(ferramentas.stringParaLong(linhaFatiada[0]), linhaFatiada[1], ferramentas.stringParaInt(linhaFatiada[2]));
//    }
}
