/**
 * Classe que representa uma célula na estrutura de dados,
 * que armazena um valor numérico.
 */
public class Variavel extends Celula {
    Double valor;

    /**
     * Construtor da classe Variavel.
     *
     * @param valorInicial O valor inicial a ser atribuído à célula.
     */
    Variavel(double valorInicial) {
        this.valor = valorInicial;
        this.prox = null;
    }

    /**
     * Retorna o valor armazenado na célula.
     *
     * @return O valor armazenado na célula.
     */
    @Override
    public Double getValor() {
        return valor;
    }
}