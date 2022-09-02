package labs1;

import java.util.Scanner;

public class PersonalizedHelloWorld {


    //input/output method
    public void personalHi(){
        Scanner input = new Scanner(System.in);
        String fullName = "";
        try{
            System.out.println("What is your name?");
            //check for empty input
            while(fullName.isBlank()){
                System.out.print("Please enter your name: ");
                fullName = input.nextLine();
            }
            //output
            System.out.println("Hello, " + fullName + "!");
            input.close();
        } catch (Exception e){
            e.printStackTrace();
        }





    }


    public static void main(String[] args) {
        PersonalizedHelloWorld test = new PersonalizedHelloWorld();

        test.personalHi();

    }
}
