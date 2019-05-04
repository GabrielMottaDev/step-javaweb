package one.attom.revisa;

import java.util.Scanner;

/**
 * @author Gabriel Motta
 * @since 13/04/2019
 */
public class Revisa {
    
     public static boolean isBisexto(int ano){
        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPrimo(int numero) {
        /* Numero primo é apenas divisivel por 1 e por ele mesmo,
         * então o for vai de 2 até um numero antes dele mesmo e verifica se é divisivel,
         * se for ele não é primo.
         * Obs: E já como todo numero é divido por 1 ou por ele mesmo isso nem foi considerado */
        for (int divi = 2; divi < numero; divi++) {
            if (numero % divi == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int numA = 1, numB = 1;
        double doubleA = 0.4242D;
        float floatA = 0.42F;
        boolean booleanA = true;
        long longA = 42424242424242L;
        char charA = 'a';
        String texto = "Teste";

        System.out.println("O valor de doubleA é: " + doubleA);
        System.out.println("Digite um ano: ");
        int ano1 = input.nextInt();
        System.out.println("Digite outro ano: ");
        int ano2 = input.nextInt();

        int maxAno = Math.max(ano1, ano2);
        int minAno = Math.min(ano1, ano2);

        int anosBi = 0;
        int numerosPrimos = 0;

        for (int ano = minAno; ano <= maxAno; ano++) {
            if (isBisexto(ano)) {
                anosBi += 1;
            }

            if (isPrimo(ano)) {
                numerosPrimos += 1;
            }
        }

        System.out.println("Anos bisextos: " + anosBi);
        System.out.println("Numeros primos: " + numerosPrimos);
    }
    
}
