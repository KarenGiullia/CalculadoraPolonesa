/**
 * Classe que representa uma estrutura de dados do tipo fila,
 * onde os elementos são inseridos no final e removidos do início da fila.
 */
public class Fila {
    Celula frente;
    Celula tras;
    /**
     *
     * Construtor da classe fila
     *
     */
    Fila() {
        frente = new Variavel(-1);
        tras = frente;
        frente.prox = null;
    }

    /**
     * Método que verifica se a fila está vazia.
     *
     * @return true se a fila estiver vazia, false caso contrário.
     */
    boolean vazia() {
        return (frente == tras);
    }

    /**
     * Método que adiciona um elemento ao final da fila.
     *
     * @param elemento Celula a ser adicionado à fila.
     */
    void enfileira(Celula elemento) {
        this.tras.prox = elemento;
        this.tras = this.tras.prox;
        this.tras.prox = null;
    }

    /**
     * Remove e retorna o elemento do início da fila.
     *
     * @return O elemento removido da fila.
     * @throws Exception Se a fila estiver vazia.
     */
    Celula desenfileirar() throws Exception {
        Celula item = null;
        if (this.vazia())
            throw new Exception("Erro: A fila está vazia");
        item = this.frente.prox;
        frente.prox = item.prox;
        item.prox = null;

        if (tras == item) {
            tras = frente;
        }

        return item;
    }

    /**
     * Exibe todos os elementos da fila.
     */
    void exibir() {
        if (vazia())
            System.out.println("Não há elementos na fila");
        else {
            Celula aux = frente.prox; // auxiliar
            // enquanto não chegar ao final
            while (aux != null) {
                System.out.println("Elemento =" + aux.getValor());
                aux = aux.prox;
            }
        }
    }
}