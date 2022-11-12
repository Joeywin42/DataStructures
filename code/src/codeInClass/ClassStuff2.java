package codeInClass;

import java.util.ArrayList;

public class ClassStuff2 {

    //clibing stairs time complexity O(2^n): space complexity is recursion
    public int climber (int steps,int stairPosition , int height){
        stairPosition = stairPosition + steps;
        if(stairPosition == height){
            System.out.println("Yay we are at top");
            return 1;
        }
        if (stairPosition > height){
            System.out.println("Height reached: " + stairPosition);
            return 0;
        }
        return climber(1, stairPosition, height) + climber(2, stairPosition, height);
    }
    //fibonachi DO Later
    public int fibonach(int num){
        if(num <= 1){
            return num;
        }
        return fibonach(num - 1) + fibonach(num - 2);
    }

    public static void main(String[] args) {
        ClassStuff2 test = new ClassStuff2();

        int steps = test.climber(0,0,5);

        System.out.println("Number of steps is " + steps);

        System.out.println("Fibo weebo");
        System.out.println(test.fibonach(10));

    }


}
