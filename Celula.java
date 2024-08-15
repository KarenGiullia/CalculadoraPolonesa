/**
 *
 * Classe abstrata que representa os elementos da expressão
 *
 */
abstract class Celula {
    Celula prox; // referência para próximo elemento

    /**
     *
     * Método abstrado que retorna o valor armazenado.
     * @return O valor armazenado nesta célula, como um objeto Object.
     */
    public abstract Object getValor();
}