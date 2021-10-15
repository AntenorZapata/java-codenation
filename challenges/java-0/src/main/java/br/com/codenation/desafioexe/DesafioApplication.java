package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

    public static List<Integer> fibonacci() {
        List fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);
        fibonacciSequence.add(1); 


        for (int i = 0; i < 12; i++) {
            int first = (int) fibonacciSequence.get(i + 1);
            int second = (int) fibonacciSequence.get(i + 2);
            fibonacciSequence.add(first + second);
        }

        return fibonacciSequence;
    }


    public static Boolean isFibonacci(Integer a) {
        int square = (int) Math.sqrt(5*a*a + 4);
        return square*square == 5*a*a + 4 || square*square == 5*a*a - 4;
    }

}

