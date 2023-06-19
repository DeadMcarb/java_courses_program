package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {


    String deleteBlanks(String str) {
        return str.replaceAll(" ", "");
    }

    boolean check (String str) {
        return checkTrash(str) &&
                checkBrackets(str) &&
                checkTwoMathActionsSequence(str);
    }


    boolean checkTrash (String str) {
        Pattern pattern = Pattern.compile("[^0-9x()=+*./\\-]");

        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("У рівнянні наявні недопустимі символи");
            return false;
        } return true;
    }

    boolean checkBrackets (String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (count < 0) {
                System.out.println("Некоректне розміщення дужок");
                return false;
            }

            if (str.charAt(i) == '(') {
                count++;
            }
            if (str.charAt(i) == ')') {
                count--;
            }

            if ((str.charAt(i) == '=')) {
                if (count != 0) {
                    System.out.println("Некоректне розміщення дужок");
                    return false;
                }
                count = 0;
            }
        }


        if (count != 0) {
            System.out.println("Некоректне розміщення дужок");
            return false;
        } return true;
    }

    boolean checkTwoMathActionsSequence(String str) {
        Pattern pattern = Pattern.compile("[+*/\\-][+*/]");

        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("Не повинно бути 2 знаків математичних операцій поспіль");
            return false;
        } return true;
    }


    int howManyNumbersAreInTheEquation (String str) {
        Pattern pattern = Pattern.compile("\\d+(?:[\\.,]\\d+)?");

        Matcher matcher = pattern.matcher(str);

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

}
