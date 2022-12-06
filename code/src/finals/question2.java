package finals;

import java.util.Stack;

public class question2 {
    // commands should be O(1)
    public int calculateStack(String[] input){
        //create stack o(n) space
        var answerStack = new Stack<Integer>();

        //converts to String arrays seperated by space  O(n) space and time; all the commands should be O(1)
        for (String e: input) {
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
        question2 test = new question2();
        String[] questionArray = {"2", "1", "+", "4", "*"};

        int answer = test.calculateStack(questionArray);

        System.out.println(answer);

    }
}
