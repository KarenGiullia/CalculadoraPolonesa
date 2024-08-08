import java.util.Vector;

public class Expressao {
    Fila expressaoTradicional =new Fila();
    Pilha expressaoPolonesa = new Pilha();
    Celula celula;
    public Fila criarExpressao(Vector<String> expressao){
        for(String caracter: expressao){
            if(caracter.equals("-") || caracter.equals("+") || caracter.equals("/") || caracter.equals("*")){
                celula = new Operador(caracter);
            }else{
                celula = new Variavel(Double.parseDouble(caracter));
            }
            expressaoPolonesa.empilhar(celula);
        }

        while (!expressaoPolonesa.vazia()){
            celula = expressaoPolonesa.desempilhar();
            if(celula instanceof Operador){

            }
        }
        return expressaoTradicional;
    }
}
