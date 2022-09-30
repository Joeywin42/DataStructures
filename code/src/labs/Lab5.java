package labs;

import java.util.ArrayList;

public class Lab5 {

    //test  case we will throw in the quickSort
    public void testCases(int[] testList){
        //check if made
        if(testList == null)
            throw new IllegalArgumentException("The array may not exist");

        //check if empty
        if(testList.length < 1){
            throw new IllegalArgumentException("array is empty");
        }
    }


    public void quickSort(int list[], int begin, int end) {
        testCases(list);
        if (begin < end) {
            //implementing the partition
            int partitionIndex = partition(list, begin, end);

            //deal with left half
            quickSort(list, begin, partitionIndex-1);
            //deal with right half
            quickSort(list, partitionIndex+1, end);
        }
    }

    //the partitioning method
    protected int partition(int list[], int begin, int end) {
        int pivot = list[end];
        int i = (begin-1);


        for (int j = begin; j < end; j++) {
            //bring the element to the point
            if (list[j] <= pivot) {
                i++;

                int swapTemp = list[i];
                list[i] = list[j];
                list[j] = swapTemp;
            }
        }

        //swapping the lesser element
        int swapTemp = list[i+1];
        list[i+1] = list[end];
        list[end] = swapTemp;

        return i+1;
    }

    //dedupplicator with o(n) time complexity
    public ArrayList<Integer> dedupper(int[] list){
        //intiate array
        var answer = new ArrayList<Integer>(list.length);
        answer.add(list[0]);
        for (int i = 1; i < list.length; i++){
            if (list[i] == list[i -1]){
                continue;
            }else {
                answer.add(list[i]);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Lab5 test = new Lab5();
        int[] testList = {50,11,33,21,40,50,40,40,21};
        //array should be [11,21,33,40,50];

        test.quickSort(testList, 0, testList.length-1);

        System.out.println(test.dedupper(testList));



    }
}
