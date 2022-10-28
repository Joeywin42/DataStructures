package labs;

import java.util.Stack;

public class Lab8 {

    //In total the operation takes O(n) space and time caused by parsing from String into String[] and the various
    // commands should be O(1)
    public int calculateStack(String input){
        //create stack o(n) space
        var answerStack = new Stack<Integer>();

        //converts to String arrays seperated by space  O(n) space and time; all the commands should be O(1)
        for (String e: input.split(" ")) {
                System.out.println(answerStack);
                //commands for operaters: pops the last two operands and does the operator detected in string
                    switch (e) {
                        case "+":
                            answerStack.push(answerStack.pop() + answerStack.pop());
                            break;
                        case "-":
                            answerStack.push(answerStack.pop() - answerStack.pop());
                            break;
                        case "*":
                            answerStack.push(answerStack.pop() * answerStack.pop());
                            break;
                        case "/":
                            answerStack.push(answerStack.pop() / answerStack.pop());
                            break;
                        default:
                            //convert from to int
                            answerStack.push(Integer.parseInt(e));
                            break;
                    }
        }
        //should return last value
        return answerStack.pop();
    }
    public static void main(String[] args) {
        //9 6 5 + 2 * +
        //= 31

        Lab8 test = new Lab8();

        System.out.println(test.calculateStack("9 6 5 + 2 * +"));

        System.out.println(test.calculateStack("12 5 + 1 -"));

        //As said previously due to parsing back and forth the complexity is O(n) for both space and time,
        //but the calculation themselves takes a complexity of O(1) for both;
        //test cases would be an if statement inside the foreach loop for seeing if it's a digit number or a operand
        // a simple if statement detecting non numbers so something like contains [0-9]|+|-|*|/ (PSUEDO REGEX NOT REAL)
        // takes out all letters which would crash the parse. also a check for isEmpty()

    }
}
