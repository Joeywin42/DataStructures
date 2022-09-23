package labs;

import java.util.Arrays;

public class Lab4 {
    //runs both the methods in order to sort the array and than deduplicate it
    public Integer[] runDeduper(Integer[] list){
        //test cases
        //Checks for null values: Not entirely sure if test case should be O(N)
        for (Integer num: list) {
            if(num == null)
                throw new IllegalArgumentException("Null input case in the array \n" +
                        "or it may not have been filled with yet");
        }
        //Checks for an array length of one
        if (list.length == 1)
            System.out.println("The array is one so there will be no duplicates");
        //Checks for empty Array
        if (list.length == 0)
            throw new IllegalArgumentException("This array is empty");

        //run methods
        return deDuplicator(bubbleSorter(list));

    }
    //sorts the array in O(n^2) time complexity: and o(1) space complexity
    private Integer[] bubbleSorter(Integer[] list) {
        int length = list.length - 1;
        int temp = 0;

        //implement bubble sort
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }
    //Deduplicates array based on whats next. Creates new array in order to return the dedupped
    //time complexity  is O(n) and space complexity is o1. We set each duplicate to Null
    private Integer[] deDuplicator(Integer[] list){
        for (int i = 0; i < list.length - 1; i++){
            if (list[i] == list[i + 1] ){
                list[i] = null;
            }
        }
        return list;
    }
    //A method that prints out the array in the correct format
    public void arrayPrinter(Integer[] list){
        StringBuilder printWord =  new StringBuilder("[");

        Arrays.stream((list)).forEach(num -> {
                    if(num != null)
                        printWord.append((num + ", "));
                });
        printWord.delete(printWord.length()-2,printWord.length());
        System.out.println(printWord + "]");
    }

    public static void main(String[] args) {
        Lab4 test = new Lab4();
        Integer[] testList = {50, 11, 33, 21, 40, 50, 40, 40, 21};
        Integer[] failList = {};

        //run method and print ignoring the null variables, and this can be easily converted to a smaller list.
        // But shifting is a O(n) Space complexity on Static Data Types.

        test.arrayPrinter(test.runDeduper(testList));
        test.arrayPrinter(test.runDeduper(failList));
    }
}
