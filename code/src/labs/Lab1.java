package labs;

import java.util.Scanner;

public class Lab1 {
    public void startCalc(){
        Scanner input = new Scanner(System.in);
        //region variables
        char operator;
        double number1;
        double number2;
        //endregion
        try {
            //asking for inputs
            System.out.println("Enter in +,-,*, or /");
            operator = input.nextLine().charAt(0);

            System.out.println("enter the first number");
            number1 = input.nextFloat();

            System.out.println("enter the second number");
            number2 = input.nextFloat();


            //displaying results form calculations method
            System.out.println("your result is");
            System.out.println(calculations(operator, number1, number2));

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Try again");
            startCalc();
        }

    }
    //encapsulated calculations
    public double calculations(char operator, double number1, double number2){
        //checking
        if (operator == '/' && number2 == 0)
            throw new IllegalArgumentException("Dividing by zero");

        //math
        switch (operator){
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
            default:
                System.out.println("Something went wrong \n" +
                        "operator: " + operator + "\n" +
                        "number1: " + number1 + "\n" +
                        "number2: " + number2);
                return -1;
        }
    }

    public static void main(String[] args) {
        Lab1 test = new Lab1();

        test.startCalc();
    }

}