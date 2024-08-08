public class Fila {
    Celula frente;
    Celula tras;
    Fila( ){
        frente = new Variavel(-1);
        tras = frente;
        frente.prox = null;
    }
    boolean vazia( ){
        return (frente == tras);
    }
    void enfileira(Celula elemento){
        this.tras.prox = elemento;
        this.tras = this.tras.prox;
        this.tras.prox = null;
    }
    Celula desenfileirar() throws Exception{

        Celula item = null;
        if (this.vazia ())
            throw new Exception ("Erro: A fila esta vazia");

        item = this.frente.prox;
        frente.prox = item.prox;
        item.prox = null;
        if (tras == item)
            tras = frente;

        return item;
    }
    void exibir( ){
        if(vazia( ))
            System.out.println("Nao ha elementos na fila");
        else{
            Celula aux = frente.prox; // auxiliar
            // enquanto não chegar ao final
            while(aux != null){
                System.out.println("Elemento ="+aux.getValor());
                        aux = aux.prox;
            }
        }
    }

}
