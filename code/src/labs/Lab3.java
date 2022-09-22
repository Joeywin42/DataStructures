package labs;

import java.util.Arrays;

public class Lab3 {
    //Rotates array by 90 degrees: Using a 2d Array: Space complexity: O(n^2); Time complexity: O(n^2)
    public int[][] rotaryDevice2D(int[][] list){
        //create temp list
        int[][] tempList = new int[list.length][list.length];
        //code
        for(int col = 0; col < list.length; col++){
            for (int row = 0; row < list.length; row++){
                tempList[col][list.length-1 - row] = list[row][col];
            }
        }
        return tempList;
    }

    //Rotates array by 90 degree: Using a 1d Array space complexity: O(n);
    public  int[][] rotaryDevice1D(int[][] list){
        //make into 1d array
        var dDArray = Arrays.stream(list).flatMapToInt(Arrays::stream).toArray();
        //manipulate 1dArray o(n)
        int countRow = list.length-1;
        int countCol = 0;
        //change 2d array
        for (int num: dDArray) {
            list[countCol][countRow] = num;
            countCol++;
            //set column back to top and move the row to the left
            if (countCol == list.length){
                countCol = 0;
                countRow--;
            }
        }
        return list;
    }

    //print 2d array as matrix
    private void array2DPrint(int[][] list){
        Arrays.stream(list).toList().forEach( col -> {
            Arrays.stream(col).forEach( row -> System.out.printf("%3d", row) );
            System.out.println();
        });
    }

    public static void main(String[] args) {
        Lab3 test = new Lab3();
        int[][] testList = {{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};
        //Code below
        int[][] methodTest1 = test.rotaryDevice2D(testList);
        int[][] methodTest2 = test.rotaryDevice1D(testList);

        //print
        //Method one making a 2d array
        test.array2DPrint(methodTest1);
        System.out.println();
        //Method two making a 1d array
        test.array2DPrint(methodTest2);
        }

    }

