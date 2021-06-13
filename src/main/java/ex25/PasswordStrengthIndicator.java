package ex25;
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Seney
 */


import java.util.Scanner;
import java.util.regex.Pattern;
public class PasswordStrengthIndicator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password to see its strength");
        String password = scanner.nextLine();

        int strength = passwordValidator(password);

        String strengthWord = "";

        if (strength == 1) {
            strengthWord = "very weak";
        } else if (strength == 2) {
            strengthWord = "weak";
        } else if (strength == 3) {
            strengthWord = "strong";
        } else if (strength == 4) {
            strengthWord = "very strong";
        } else {
          //  strengthWord = "very weak";
        }

        System.out.println("The password '" + password + "' is a " + strengthWord + " password.");
    }

    public static int passwordValidator(String input){
        int length;
        boolean numbersOnly = true;
        boolean lettersOnly = true;
        int numberCounter = 0;
        int letterCounter = 0;
        boolean isSpecialChars = false;
        length = input.length();
        input = input.toLowerCase();
        char[] inputArray = input.toCharArray();


        for (int i = 0; i < length; i++){

            if (!(inputArray[i] >= '0' && inputArray[i] <= '9')){
                numbersOnly = false;
            }
            else{
                numberCounter += 1;
            }

            if (!(inputArray[i] >= 'a' && inputArray[i] <= 'z')){
                lettersOnly = false;
            }
            else{
                letterCounter += 1;
            }

            if ((inputArray[i] >= ':' && inputArray[i] <= '@') || (inputArray[i] >= '!' && inputArray[i] <= '/') ||
                    (inputArray[i] >= '[' && inputArray[i] <= '`') || (inputArray[i] >= '{' && inputArray[i] <= '~')){
                isSpecialChars = true;
            }
        }



        if (length < 8 && numbersOnly == true){
            return 1;
        }

        if (length < 8 && lettersOnly == true){
            return 2;
        }

        if (length >= 8 && numberCounter >= 1 && letterCounter >= 1 && isSpecialChars == false){
            return 3;
        }

        if (length >= 8 && numberCounter >= 1 && letterCounter >= 1 && isSpecialChars == true){
            return 4;
        }

        return 0;
    }
}
