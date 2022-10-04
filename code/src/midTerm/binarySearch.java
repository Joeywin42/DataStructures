package midTerm;

public class binarySearch {
    //binary Search that finds it in logn, returns index
    public int binarySearch(int[] list, int target, int low, int high){
        //System.out.println("Running Binary Search");
        while(low != high){
            int mid = (low + high)/2;
            //if the element is found immediately return it
            if (target == list[mid]) {
                System.out.println(list[mid] + " is at Index:");
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



    public static void main(String[] args) {
        binarySearch test = new binarySearch();
        int[] testList = {11, 21, 33, 40, 50};
        //target is 21

        System.out.println(test.binarySearch(testList, 21, 0, testList.length));






    }
}
