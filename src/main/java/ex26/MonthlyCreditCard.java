package ex26;
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Seney
 */

import java.util.Scanner;

import static java.lang.Math.log;

public class MonthlyCreditCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter balance of credit card");
        double creditCardBalance = scanner.nextDouble();

        System.out.println("Enter the APR of the card as a percentage");
        double apr = scanner.nextDouble();

        System.out.println("What is the monthly payment");
        double monthlyPayment = scanner.nextDouble();

        double monthsLeft = PaymentCalculator.calculateMonthsUntilPaidOff(creditCardBalance, apr, monthlyPayment);

        System.out.println(monthsLeft);
    }
}

 class PaymentCalculator {

    public static double calculateMonthsUntilPaidOff(double balance, double apr, double payment){
        double left;
        double dailyRate;
       // apr =  apr/100;
        dailyRate = apr / 365;
        System.out.println(dailyRate);
        System.out.println("balance " + balance);
        System.out.println("payment " + payment);

        left = -(1/30) * Math.log(1 + balance/payment * (1 - Math.pow((1 + dailyRate),30))) / Math.log(1 + dailyRate);
        System.out.println(left);
        Math.round(left);

        return left;
    }
}
