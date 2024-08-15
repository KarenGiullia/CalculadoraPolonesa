import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * Classe responsável por ler e processar um arquivo de texto.
 *
 */
public class LeitorArquivo {
    private String diretorioArquivo;
    BufferedReader entradaDeDados;

    /**
     * Construtor da classe LeitorArquivo.
     *
     * @param diretorioArquivo String contendo o diretório do arquivo da base de dados.
     * @throws FileNotFoundException Se o arquivo especificado não for encontrado.
     */
    public LeitorArquivo(String diretorioArquivo) throws FileNotFoundException {
        this.diretorioArquivo = diretorioArquivo;
        this.entradaDeDados = new BufferedReader(new FileReader(diretorioArquivo));
        //this.ferramentas = new Ferramentas(); // Comentado porque não está sendo usado atualmente
        //this.tamanhoLinha = tamanhoLinha; // Comentado porque não está sendo usado atualmente
    }

    /**
     * Retorna o diretório do arquivo da base de dados.
     *
     * @return O diretório do arquivo.
     */
    public String getDiretorioArquivo() {
        return diretorioArquivo;
    }

    /**
     * Define o diretório do arquivo da base de dados.
     *
     * @param diretorioArquivo O novo diretório do arquivo.
     */
    public void setDiretorioArquivo(String diretorioArquivo) {
        this.diretorioArquivo = diretorioArquivo;
    }

    /**
     * Fatia uma linha do arquivo em substrings separadas por espaços e as coloca em uma fila.
     * Cada elemento da linha é convertido em uma célula, sendo uma instância de
     * {@link Operador} ou {@link Variavel}, dependendo do conteúdo do elemento.
     *
     * @return Uma fila contendo as células representando a linha do arquivo, ou null se a linha estiver vazia ou o final do arquivo for alcançado.
     */
    public Fila fatiarLinha() {
        Vector<String> linhaFatiada = new Vector<>();
        Celula celula;
        Fila fila = new Fila();
        try {
            String linha = entradaDeDados.readLine(); // Lê a linha do arquivo
            if (linha != null) {
                String[] linhaVetor = linha.split(" ");
                linhaFatiada.addAll(Arrays.asList(linhaVetor)); // Adiciona os elementos ao vetor
                // Cada elemento do vetor é colocado em uma fila
                for (String elemento : linhaFatiada) {
                    if (elemento.equals("-") || elemento.equals("+") || elemento.equals("/") || elemento.equals("*")) {
                        celula = new Operador(elemento);
                    } else {
                        celula = new Variavel(Double.parseDouble(elemento));
                    }
                    fila.enfileira(celula);
                }
            } else {
                fila = null; // Retorna null se não houver mais linhas para ler
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fila;
    }
}
