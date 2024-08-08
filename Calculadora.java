import java.util.Vector;

public class Calculadora {
    Pilha pilha = new Pilha();
    Celula variavel;

    public double calcular(Vector<String> expressao){
        for(String caracter: expressao){
            if (!(caracter.equals("-") || caracter.equals("+") || caracter.equals("/") || caracter.equals("*"))){  //se nao for sinal
                //empilha na pilha
                variavel = new Variavel(Double.parseDouble(caracter));
                pilha.empilhar(variavel);
//                pilha.exibir();
//                System.out.println();
            }else{  //se for sinal
                //desempilha valor1
                variavel = pilha.desempilhar();

                double valor1 = (double)variavel.getValor();
//                pilha.exibir();
//                System.out.println();
                //desempilha valor2
                variavel = pilha.desempilhar();

                double valor2 = (double)variavel.getValor();
//                pilha.exibir();
//                System.out.println();
                //faz a conta
                if(caracter.equals("-")){
                    double resultado = valor2-valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                } else if(caracter.equals("+")){
                    double resultado = valor2+valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                } else if(caracter.equals("/")){
                    double resultado = valor2/valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                }else if(caracter.equals("*")){
                    double resultado = valor2*valor1;
                    variavel = new Variavel(resultado);
                    pilha.empilhar(variavel);
                }
            }

        }
        //desempilha o ultimo
        variavel = pilha.desempilhar();
        return (double)variavel.getValor();    //retorna o valor
    }
}
