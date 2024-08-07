import java.util.Vector;

public class Calculadora {
    Pilha pilha = new Pilha();
    Celula celula;

    public double calcular(Vector<String> expressao){
        for(String caracter: expressao){
            if (!(caracter.equals("-") || caracter.equals("+") || caracter.equals("/") || caracter.equals("*"))){  //se nao for sinal
                //empilha na pilha
                celula = new Celula(Double.parseDouble(caracter));
                pilha.empilhar(celula);
            }else{  //se for sinal
                //desempilha valor1
                celula = pilha.desempilhar();
                double valor1 = celula.valor;
                //desempilha valor2
                celula = pilha.desempilhar();
                double valor2 = celula.valor;
                //faz a conta
                if(caracter== "-"){
                    double resultado = valor2-valor1;
                    celula = new Celula(resultado);
                    pilha.empilhar(celula);
                } else if(caracter== "+"){
                    double resultado = valor2+valor1;
                    celula = new Celula(resultado);
                    pilha.empilhar(celula);
                } else if(caracter== "/"){
                    double resultado = valor2/valor1;
                    celula = new Celula(resultado);
                    pilha.empilhar(celula);
                }else if(caracter== "*"){
                    double resultado = valor2-valor1;
                    celula = new Celula(resultado);
                    pilha.empilhar(celula);
                }
            }

        }
        //desempilha o ultimo
        celula = pilha.desempilhar();
        return celula.valor;    //retorna o valor
    }
}
