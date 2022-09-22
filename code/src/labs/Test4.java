package labs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {
    //runs both the methods in order to sort the array and than deduplicate it
    public ArrayList<Integer> runDeduper(ArrayList<Integer> list){
        return deDuplicator(bubbleSorter(list));

    }
    //sorts the array in O(n^2) complexity
    public ArrayList<Integer> bubbleSorter(ArrayList<Integer> list) {
        int length = list.size() - 1;
        int temp = 0;

        //implement bubble sort
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                if (list.get(j) > list.get(j+1)) {
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    //Deduplicates array based on whats next. Creates new array in order to return the dedupped
    public ArrayList<Integer> deDuplicator(ArrayList<Integer> list){
        int size = list.size();


        return list;
    }




    public static void main(String[] args) {
        Test4 test = new Test4();
        //Take in as static Array and make it Array List
        //TA told me to use ArrayList
        int[] testList = {50, 11, 33, 21, 40, 50, 40, 40, 21};
        var newList = new ArrayList<Integer>();

        for (int num: testList) {
            newList.add(num);
        }


        //run method and print
        (test.runDeduper(newList))
                .forEach(number -> System.out.print(number + ", "));

    }
}