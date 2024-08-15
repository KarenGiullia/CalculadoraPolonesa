/**
 * Classe que representa uma célula na estrutura de dados que armazena um operador aritmético.
 */
public class Operador extends Celula {
    String valor;

    /**
     * Construtor da classe Operador.
     *
     * @param valorInicial O valor inicial do operador a ser atribuído à célula.
     */
    Operador(String valorInicial) {
        this.valor = valorInicial;
        this.prox = null;
    }

    /**
     * Retorna o valor do operador armazenado na célula.
     *
     * @return O valor do operador armazenado na célula.
     */
    @Override
    public String getValor() {
        return valor;
    }
}