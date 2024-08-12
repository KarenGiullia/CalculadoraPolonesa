public class Variavel extends Celula {
    Double valor; // valor da célula
    Variavel(double valorInicial){
        this.valor = (Double) valorInicial;
        this.prox = null;
    }

    @Override
    public Double getValor() {
        return valor;
    }
}
