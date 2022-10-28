package labs;
import java.util.ArrayDeque;


//designed a wrapper class for the two queues to make it feel like one queue normal is still public though so it can be
//accessed as a normal queue
public class Lab9 {
    //deque first in first out
    public ArrayDeque normal = new ArrayDeque();
    //privated as they should not be able to access the max queue fully
    private ArrayDeque maxQueue = new ArrayDeque<>();

    //adds element and checks for queue max
    public void enque(int num){
        //adds element to main
        normal.add(num);

        //add first element if null
        if (maxQueue.peek() == null) {
            maxQueue.add(num);
        }
        //after the null check
        else {
            //delete all the first elements until its greater than or equal to first;
            while ((int)maxQueue.peek() < num){
                maxQueue.pop();
                if (maxQueue.peek() == null)
                    break;
            }
            //delete all the last elements until it's greater than or equal to last
            while (maxQueue.peekLast() != null && (int)maxQueue.peekLast() < num){
                maxQueue.removeLast();
                if (maxQueue.peekLast() == null)
                    break;
            }

            maxQueue.add(num);
        }
    }
    public void deque(){
        //pop first element and give it temp
        int temp = (int) normal.pop();
        //check if temp is equal to peek and pop the maxqueue
        if (temp == (int)maxQueue.peek())
            maxQueue.pop();
    }

    public int getMax(){
        return (int) maxQueue.peek();
    }

    @Override
    public String toString(){
        return normal.toString();
    }




    public static void main(String[] args) {
        int[] test = {3, 2, 4, 1};
        Lab9 tester = new Lab9();

        tester.enque(1);
        tester.enque(4);
        tester.enque(2);
        tester.enque(3);

        System.out.println(tester);
        System.out.println(tester.getMax());

        System.out.println(tester.maxQueue);

        tester.deque();
        tester.deque();


        System.out.println(tester.maxQueue);
        tester.getMax();


        //In order to make the code I had to already have implemented several test cases like checking for null or a list
        // of one. Also the main method has the test.

    }




}
