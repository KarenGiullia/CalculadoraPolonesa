public class Pilha {
    Celula topo;
    int quantos;
    Pilha( ){
        topo = null;

        quantos = 0; // nenhum elemento na pilha
    }

    boolean vazia( ){
        return (topo == null);
    }
    void empilhar(Celula elemento){
        elemento.prox = topo;
        topo = elemento;
        quantos++;
    }
    Celula desempilhar(){

        if(vazia( )){
            System.out.println("Err: Nao ha' itens na pilha");
            return null;
        }else{
            Celula aux = topo; //aponta pra 1a célula válida
            topo = topo.prox;
            aux.prox = null;
            quantos--; // atualiza número de elementos
            return aux;
        }
    }
    void esvaziar( ){
        topo = null;
    }
    void exibir( ){
        if(vazia( ))
            System.out.println("Nao ha elementos na pilha");
        else{
            Celula aux = topo; // auxiliar
            // enquanto não chegar no fundo
            while(aux != null){
                System.out.println("Elemento =" + aux.valor);
                        aux = aux.prox;
            }
        }
    }
}
