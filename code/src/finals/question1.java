package finals;

import java.util.HashSet;

public class question1 {

    public static void main(String[] args) {
        //question array
        int[] testArray = {1, 2, 3, 4, 4, 6, 6, 6};

        //create hashset O(n) space
        HashSet<Integer> answer = new HashSet<Integer>();

        //add in each element and it checks for duplicates due to hash strucure in o constant making the operation o(n)
        for (int e: testArray){
            answer.add(e);
        }
        System.out.println(answer);
    }
}
