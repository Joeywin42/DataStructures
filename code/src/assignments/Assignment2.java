package assignments;

import java.util.Stack;

public class Assignment2 {
    //two stacks to store values for the whole class to use
    private Stack<Integer> operands = new Stack<Integer>();
    private Stack<String> operaters = new Stack<String>();

    //some simple test cases for the String
    private void testCases(String expression){
        if (expression.length() < 1)
            throw new IllegalArgumentException("This String is way to small for this calculator");
        if (expression.isBlank()){
            throw new IllegalArgumentException("This String is way to small for this calculator");
        }
    }
    //O(n) space and O(n) time for calculations
    public int calculate(String expression){
        //turn the expression into the stacks
        testCases(expression);
        converter(expression);
        int temp = 0;
        //calculations
        while(operands.size() > 1 && operaters.size() >= 1){
            temp = operands.pop();
            operands.push(calc(temp, operands.pop(), operaters.pop()));

            //Process of calculations.
            System.out.println("\n" + operands + " :Operand List process");
            System.out.println(operaters + " :Operator List process");
        }
        return operands.pop();
    }
    //turn the expression into the operator and operands stack becoming in o(n) time complexity
    //and will become O(n) space to account for large digit numbers and less math conversion from characters
    private void converter(String expression){
        //create array of Strings split by space.
        String[] expressionList = expression.split(" ");
        //currently reads right to left due to stack properties,so now we must reverse the array
        //simple swap mechanic for o(n) time and o(1) space
        String temp = "";
        for(int i = 0; i < expressionList.length/2; i++){
            temp = expressionList[i];
            expressionList[i] = expressionList[expressionList.length - i - 1];
            expressionList[expressionList.length - i - 1] = temp;
        }

        for (String e: expressionList) {
            //check for numbers and adds to operands
            if (e.matches("^[0-9]+$")){
                operands.push(Integer.parseInt(e));
            } else
            //checks for operaters and adds to operaters
            if (e.matches("\\*|\\/|\\+|\\-")){
                operaters.push(e);
            } else{         // If there is a non digit value or non operand call an error
                System.out.println("There is something illegal here.");
                throw new ArithmeticException("There is Illegal argument inside of the expression givin");
            }
        }
        //prints the converted list for debugging
        System.out.println(operands + " :operands total List");
        System.out.println(operaters + " :operators total List");
    }
    //abstracted the calculations
    private int calc(int operand1, int operand2, String operator){
        //do the operation based on operator
        return switch (operator){
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "/" -> operand1 / operand2;
            case "*" -> operand1 * operand2;
            default -> -1;
        };
    }
    public static void main(String[] args) {
        //10 * 2 - 15 has to return 5
        //separated by spaces
        Assignment2 tester = new Assignment2();

        String expression = "10 * 2 - 15";

        System.out.println(tester.calculate(expression) + " :Answer");


//        There is several test cases at the very top of the code and inside the converter method for empty arrays
//        and illegal arguments.

    }
}
