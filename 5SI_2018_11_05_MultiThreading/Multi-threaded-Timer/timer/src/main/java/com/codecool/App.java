package com.codecool;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        TimerContainer timerContainer = new TimerContainer();
        Scanner input = new Scanner(System.in);
        System.out.println("Command?");
        String choice = input.nextLine();

        while (!(choice.equalsIgnoreCase("exit"))) {

            timerContainer.handleTimers(choice);
            System.out.println("Command?");
            choice = input.nextLine();
        }
        timerContainer.getAllTimers();
        timerContainer.stopAllTimers();
    }
}
