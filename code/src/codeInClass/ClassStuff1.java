package codeInClass;

import java.util.Arrays;

public class ClassStuff1 {
    //o(n)^2
    public int dockers(int[] list){
        int maxArea = 0;
        int area = 0;
        int length = list.length;
        int width = 0;

        for (int i = 0; i < length; i++){
            for (int j = 0; j < length ; j++){
                width = (j - i);
                if (width < 0)
                    width = width * -1;
               area = Math.min(list[i], list[j]) * (width);
                //System.out.println(width + "  WIDTH OF WHOLE");
               if(maxArea < area) {
                   maxArea = area;
               }
            }
        }
        return maxArea;
    }

    public int[] arrayThingie(int[] list){
        int[] answer = new int[list.length];
        int temp = 0;
        int tempAnswer = 1;

        //currently o(n)^2
        for (int i = 0; i < list.length; i++){
            temp = list[i];
            list[i] = 1;
            for (int num: list){
                tempAnswer *= num;
            }
            answer[i] = tempAnswer;
            tempAnswer = 1;
            list[i] = temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        ClassStuff1 test = new ClassStuff1();
        int[] list = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //             0  1 2 3 4   5   6  7  8

        //System.out.println(test.dockers(list));

        //Four element array [1, 2, 3, 4]
        // Answer [x1, x2, x3, x4] same length products elimating location
        // answer [24, 12, 8, 6] no division allowed
        //2 * 3 * 4 = 24, 1 * 3 * 4 = 12, 1 * 2 * 4 = 8, 1 * 2 * 3 = 6;
        //go for space complexity of o(1) no arrays. linear
        int[] testArrayThingie = {1, 2, 3, 4};

        Arrays.stream(test.arrayThingie(testArrayThingie)).forEach(x -> System.out.print(x + ", "));








    }
}
