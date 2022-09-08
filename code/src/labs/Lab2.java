package labs;

public class Lab2 {

    //o(n)^2 but is o(1) space complexity
    public void rearranger(int[] list){
        System.out.println("Running Rearranger");
        int length = list.length;
        int temp = 0;
        for(int i = 0; i < length - 1; i++){
            for (int j = 0; j < length - i - 1; j++){
                //if number is greater than next swap em
                if (list[j] > list[j + 1]){
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    //o(n)
    public int arrayPrintPlus(int[] list){
        String number = "";
        for (int num: list) {
            number += num;
        }

        //convert String plus one to an int;
        return (Integer.parseInt(number) + 1);
    }

    public static void main(String[] args) {
        Lab2 test = new Lab2();
        int[] testList = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int[] testList2 = {1,9,8,9};


        //question one
        test.rearranger(testList);

        for (int num: testList) {
            System.out.print(num + ", ");
        }

        System.out.println("---------------------------------------");

        //question two
        System.out.println(test.arrayPrintPlus(testList2));







    }
}
