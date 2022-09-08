package codeInClass;

public class binarySearchTest {
    public int binarySearch(int[] list, int target){
        int low = 0;
        int high = list.length-1;
        int mid;
        int x = target;

        //the problem circular array search get minimum value. ie 1


        while(low <= high){
            mid = (low + high)/2;

            if(x == list[mid])
                return mid;

            if(x > list[mid]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }



        }

        return -1;

    }
    //squareroot binary search

    public int binaryRoot(int number){
        //int quotient = 0;
        //int[] list = new int[number];                               //O(1) time
        int low = 1;
        int high = number;
        int mid = 0;
        int midSquare;
        int runs = 0;
        System.out.println("Running Binary Root");

        while(low < high) {
            System.out.println("run " + runs);

            mid = (high + low)/2;
            midSquare = mid * mid;
            System.out.println(mid);
            if (midSquare == number)
                return mid;
            if (midSquare < number)
                low = mid;
            else{
                high = mid;
            }
            runs++;

        }

        return -1;
    }


    public static void main(String[] args) {
       int[] numList = {5,7,10,15,17,1,2};

       binarySearchTest test = new binarySearchTest();
        //System.out.println(test.binarySearch(numList, 17));

        System.out.println(test.binaryRoot(144));
    }
}
