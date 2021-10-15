package br.com.codenation.calculadora;


public class CalculadoraSalario {

    public static void main(String[] args) {
        System.out.println(calcularSalarioLiquido(5000));
    }

    //Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
    private static double calculateDiscount(double salary, double percent) {
        salary -= (salary * percent);
        return salary;
    }

    public static double calculateIRRF(double newSalary) {

        double finalSalary;
        if (newSalary < 3000) {
            finalSalary =  newSalary;
        } else if (newSalary > 3000 && newSalary <= 6000) {
            newSalary = calculateDiscount(newSalary, 0.075);
            finalSalary = newSalary;
        } else {
            newSalary = calculateDiscount(newSalary, 0.15);
            finalSalary =  newSalary;
        }
        return finalSalary;
    }

    public static int calcularSalarioLiquido(double salarioBase) {
        //Use o Math.round apenas no final do método para arredondar o valor final.
        //Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
        double salaryDisconted;

        if (salarioBase < 1039 || salarioBase > 1e99) {
            return 0;
        } else if (salarioBase <= 1500) {
            salaryDisconted = calculateDiscount(salarioBase, 0.08);
        } else if (salarioBase > 1500 && salarioBase <= 4000) {
            salaryDisconted = calculateDiscount(salarioBase, 0.09);
        } else {
            salaryDisconted = calculateDiscount(salarioBase, 0.11);
        }
        double finalSalary = calculateIRRF(salaryDisconted);
        return (int) Math.round(finalSalary);
    }


}