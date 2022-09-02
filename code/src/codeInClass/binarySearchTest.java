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
            else if(x > list[mid]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }



        }

        return -1;

    }


    public static void main(String[] args) {
       int[] numList = {5,7,10,15,17,1,2};

       binarySearchTest test = new binarySearchTest();
        System.out.println(test.binarySearch(numList, 17));
    }
}
