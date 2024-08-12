public class Operador extends Celula {
    String valor; // valor da célula
    Operador(String valorInicial){
        this.valor = valorInicial;
        this.prox = null;
    }

    @Override
    public String getValor() {
        return valor;
    }

}
