public class Celula {
    double valor; // valor da célula
    Celula prox; // referência para próximo elemento

    Celula(double valorInicial){
        valor = valorInicial;
        prox = null;
    }
}
