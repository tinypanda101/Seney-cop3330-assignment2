package ex27;
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Seney
 */

import java.util.Scanner;

public class ValidatingInputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first name");
        String firstName = scanner.nextLine();

        System.out.println("Enter the last name");
        String lastName = scanner.nextLine();

        System.out.println("Enter the ZIP code");
        String zipCode = scanner.nextLine();

        System.out.println("Enter the employee ID");
        String employeeID = scanner.nextLine();

        String output = validateInput(firstName, lastName, zipCode, employeeID);

        System.out.print(output);
    }

    public static String validateInput(String first, String last, String zip, String ID){

        boolean emptyFirst;
        boolean emptyLast;
        boolean firstLength;
        boolean lastLength;
        boolean formatID;
        boolean formatZip;
        String output = "";

        emptyFirst = filledIn(first);

        emptyLast = filledIn(last);

        firstLength = stringLength(first);

        lastLength = stringLength(last);

        formatID = employeeFormat(ID);

        formatZip = zipcodeFormat(zip);

        if (emptyFirst == true) {
            output = output + "The first name must be filled in.\n";
        }

        if (emptyLast == true){
            output = output + "The last name must be filled in.\n";
        }

        if (firstLength == false){
            output = output + "The first name must be at least 2 characters long\n";
        }

        if (lastLength == false){
            output = output + "The last name must be at least 2 characters long\n";
        }

        if (formatZip == false) {
            output = output + "The zipcode must be a 5 digit number\n";
        }

        if (formatID == false) {
            output = output + "The ID must be in the format AA-1111\n";
        }

        if (output == ""){
            output = "There were no errors found";
        }

        return output;
    }

    public static boolean filledIn(String input){
        boolean empty;
        empty = input.isEmpty();
        return empty;
    }

    public static boolean stringLength(String input){
        boolean length;
        if(input.length() >= 2) {
            length = true;
        }
        else{
            length = false;
        }
        return length;
    }

    public static boolean employeeFormat(String input){
        boolean format = false;
        char chArray[] = input.toCharArray();
        int length = input.length();

        for(int i = 0; i < length; i++){

            if (i == 0 || i == 1){
                if((chArray[i] >= 'A' && chArray[i] <= 'Z') || (chArray[i] >= 'a' && chArray[i] <= 'z')){
                    format = true;
                }
                else {
                    return false;
                }
            }
            else if (i == 2){
                if(chArray[i] == '-'){
                    format = true;
                }
                else {
                    return false;
                }
            }
            else if (i > 2){
                if((chArray[i] >= '0' && chArray[i] <= '9')){
                    format = true;
                }
                else {
                    return false;
                }
            }
        }

        return format;
    }

    public static boolean zipcodeFormat(String input){
        boolean format = true;
        char chArray[] = input.toCharArray();
        int length = input.length();

        if (length < 5){
            return false;
        }

        for(int i = 0; i < length;i++){
            if (!(chArray[i] >= '0' && chArray[i] <= '9')){
                format = false;
            }
        }

        return format;
    }
}
