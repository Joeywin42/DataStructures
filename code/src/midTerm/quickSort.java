package midTerm;

import java.util.Arrays;

public class quickSort {


    //OnLogn Sorting algorithm
    public void quickSort(int list[], int begin, int end) {
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

                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;

            }
        }
        //swapping the lesser element
        int swapTemp = list[i+1];
        list[i+1] = list[end];
        list[end] = swapTemp;

        return i+1;
    }





    public static void main(String[] args) {
        quickSort test = new quickSort();
        int[] testList = {50, 11, 33, 21, 40, 50, 40, 40, 21};
        //sort this array


        test.quickSort(testList, 0, testList.length - 1);
        //Print the sorted array

        Arrays.stream(testList).forEach(num -> System.out.print(num + " "));



    }
}


