package labs1;

import java.util.Scanner;

public class GuessMyNumber {
    //establishes start of HLC
    public void start(){
        Scanner input = new Scanner(System.in);
        int number = 0;
        int floor = 0;
        int ceiling;
        int[] stored = new int[2];
        String response = "";
        try {
            System.out.println("Enter n: ");
            number = input.nextInt();

            //checker
            while (number == 0 || number < 0) {
                System.out.println("Enter a positive integer for n: ");
                number = input.nextInt();
            }
            number--;
            input.nextLine();
            //welcoming + output
            System.out.println("Welcome to Guess My Number!" +
                    "\nPlease think of a number between 0 and " + number + ".");
            ceiling = number;
            number = (int) Math.ceil(number/2.0);
            System.out.println("Is your number: " + number + "?");
            System.out.println("Please enter C for correct, H for too high, or L for too low.");
            while (true){

                System.out.println("Enter your response (H/L/C): ");
                response = input.nextLine();
                //correct statement
                if (response.equals("C"))
                    break;
                //logic and changes
                if (response.equals("H")){
                    ceiling = number;
                } else if (response.equals("L")){
                    floor = number;
                } else continue;
                //continue

                System.out.println(floor + " " + ceiling + " " +number);
                number = (int) Math.ceil((floor + ceiling)/2.0);

                System.out.println("Is your number: " + number + "?");
                System.out.println("Please enter C for correct, H for too high, or L for too low.");
            }
            //the final print after C
            System.out.println("Thank you for playing Guess my Number!");

        } catch (Exception e){

        }
    }


    public static void main(String[] args) {
        GuessMyNumber test = new GuessMyNumber();
        test.start();

    }
}
