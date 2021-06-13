package ex24;
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Seney
 */


import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String firstString;
        String secondString;

        System.out.println("Enter two strings to see if they are anagrams:");
        System.out.print("Enter the first string: ");
        firstString = scanner.nextLine();
        System.out.print("Enter the second string: ");
        secondString = scanner.nextLine();


        boolean tf = isAnagram(firstString, secondString);

        if (tf == true){
            System.out.println(firstString + " and " + secondString +" are anagrams");
        }
        else {
            System.out.println(firstString + " and " + secondString +" are not anagrams");
        }
    }

    public static boolean isAnagram(String firstString, String secondString){
       boolean tf;

        if (firstString.length() != secondString.length()) {
            return false;
        }

        char[] str1 = firstString.toLowerCase().toCharArray();
        char[] str2 = secondString.toLowerCase().toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        tf = Arrays.equals(str1, str2);

        return tf;
    }
}
