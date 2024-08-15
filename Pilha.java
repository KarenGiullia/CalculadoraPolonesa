/**
 * Classe que representa uma estrutura de dados do tipo pilha,
 * onde os elementos são inseridos no topo e removidos do topo da pilha.
 */
public class Pilha {
    Celula topo;
    int quantos;

    /**
     * Construtor da classe Pilha. Inicializa a pilha vazia.
     */
    Pilha() {
        topo = null;
        quantos = 0; // Nenhum elemento na pilha
    }

    /**
     * Verifica se a pilha está vazia.
     *
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    boolean vazia() {
        return (topo == null);
    }

    /**
     * Adiciona um elemento ao topo da pilha.
     *
     * @param elemento Celula a ser adicionado à pilha.
     */
    void empilhar(Celula elemento) {
        elemento.prox = topo;
        topo = elemento;
        quantos++;
    }

    /**
     * Remove e retorna o elemento do topo da pilha.
     *
     * @return O elemento removido do topo da pilha. Retorna null se a pilha estiver vazia.
     */
    Celula desempilhar() {
        if (vazia()) {
            System.out.println("Err: Não há itens na pilha");
            return null;
        } else {
            Celula aux = topo; // Aponta para a célula atual no topo
            topo = topo.prox;
            aux.prox = null;
            quantos--; // Atualiza o número de elementos
            return aux;
        }
    }

    /**
     * Esvazia a pilha, removendo todos os elementos.
     */
    void esvaziar() {
        topo = null;
        quantos = 0; // Atualiza o número de elementos
    }

    /**
     * Exibe todos os elementos da pilha.
     */
    void exibir() {
        if (vazia()) {
            System.out.println("Não há elementos na pilha");
        } else {
            Celula aux = topo; // Auxiliar
            // Enquanto não chegar ao final
            while (aux != null) {
                System.out.println("Elemento =" + aux.getValor());
                aux = aux.prox;
            }
        }
    }
}