package assignments;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment1 {
    //Just for checking the amount of runs
    int counterFast = 0;
    //Test Case method to make sure the array is legal.
    public void testCases(int[]list1, int[] list2){
        //check if the size is at least one
        if (list1.length < 1 || list2.length < 1)
            throw new IllegalArgumentException("At least one of the arrays are empty");

        //check if the arrays exist
        if (list1 == null || list2 == null)
            throw new IllegalArgumentException("At least one of the arrays does not exist");
    }

    //solves the equation with O(mn) time complexity and o(n) space complexity
    public ArrayList<Integer> slowBoy(int[] list1, int[] list2){
        //debugging
        System.out.println("running SlowBoy");
        testCases(list1, list2);
        //create answer array with lowest length initialized to minumum for performance.
        var answer = new ArrayList<Integer>(lengthFinder(list1, list2));
        int aCounter = 0;
        int runCounter = 0;
        //initialize temp to be used
        int temp = -2147483647;
        //iterate over the array while checking the other array for duplicates each time
        for (int l1 = 0; l1 < list1.length;l1++){
            for (int l2 = 0; l2 < list2.length; l2++){
                //Check if the number of List 1 is equal to List 2 and not the previous number to add to answer array
                if (list1[l1] == list2[l2] && list1[l1] != temp){
                    temp = list1[l1];
                    answer.add(list1[l1]);
                    aCounter++;
                    System.out.println("Added " + list1[l1]);
                }
                //check runs
                runCounter++;
            }
        }
        System.out.println("Slow boy ran: " + runCounter + " times! :(");
        return answer;
    }

    public ArrayList<Integer> fastBoy(int[] list1, int[] list2){
        //debugging
        System.out.println("Running FastBoy");
        testCases(list1, list2);
        //create answer array with lowest arraysize as initailization
        var answer = new ArrayList<Integer>(lengthFinder(list1, list2));
        int temp = -2147483647;
        int temp2 = 0;
        //Iterate through first array and use binary search to find duplicate in other array
        for(int l1 = 0; l1 < list1.length; l1++){
            if (list1[l1] != temp){
                temp = list1[l1];
                temp2 = binarySearch(list2, list1[l1], 0, list2.length);
                //^^ find the duplicate Index if it can ^^

                //add found element
                if (temp2 != -1 && list2[temp2] == temp) {
                    System.out.println("added number: " + list1[l1]);
                    answer.add(list1[l1]);
                }
            }
            //check runs
            counterFast++;
        }
        System.out.println("Fast boy ran: " + counterFast + " times! :)");
        counterFast = 0;
        return answer;
    }
    //Using binary search to find corresponding duplicate in l2;
    public int binarySearch(int[] list, int target, int low, int high){
        //System.out.println("Running Binary Search");
        while(low != high){
            counterFast++;
            int mid = (low + high)/2;
            if (target == list[mid]) {
                System.out.println("Found the target!!");
                return mid;
            }
            else if (target < list[mid]) {
                high = mid; // target on right
            } else {
                low = mid; // target on left
            }
        }

        System.out.println("search could not resolve");
        return -1;
    }

    //Method used to find max length and put it inside method
    public int lengthFinder(int[] l1, int[] l2){
        //debugging
        System.out.println("Running Length Finder");
        return Math.min(l1.length, l2.length);
    }

    //have a printer statement
    public void arrayPrinter(ArrayList<Integer> list){
        StringBuilder answer = new StringBuilder("\n[");
        list.forEach(num -> answer.append(num + ", "));
        answer.delete(answer.length()-2, answer.length())
                .append("]");
        System.out.println(answer);
    }
    //Tester main and location of question 3 answer
    public static void main(String[] args) {
        Assignment1 test = new Assignment1();

        int[] array1 = {1,5,6,6,9,9,9,11,11,21};

        int[] array2 = {6,6,9,11,21,21,21};


        //testing the arrays
        test.arrayPrinter(test.slowBoy(array1, array2));
        System.out.println("OUTPUT OF SLOW BOY\n");

        test.arrayPrinter(test.fastBoy(array1, array2));
        System.out.println("OUTPUT OF FAST BOY");


        /* Question 3
            Since the arrays are already sorted we can just iterate over the first array and check the first element in
            the second array. If there is no match than there is no duplicates. after a match is found we can move the
            second array pointer to the next non repeating element. In this example its 9. Then we continue with the first loop
            loop and try to match with that. Until the end of the loops.

            Iterating over the first loop is O(n) than moving the pointer from the second loop should also be O(n) but
            since it only iterates until the next element is found it would be very small amount. compared to the whole array
            in this case the max case would be 2 it should be around o(1) so overall the next way to this should be around
            O(n) + O(m) making it around O(n) since it just iterates over both arrays a maximum of one time.

         */

    }
}
