package org.example;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler();
    public static void main(String[] args) {
        new Main().run();
    }
    private int printMenu() {
        System.out.println("""
                1. Ввести рівння
                2. Закрити програму""");
        System.out.print(">> ");
        int a = scanner.nextInt();
        scanner.nextLine();
        return a;
    }

    private void run() {
        loop:
        while (true) {
            switch (printMenu()) {

                case 1 -> {
                    String str = inputHandler.deleteBlanks(scanner.nextLine());
                    if (inputHandler.check(str)) {
                        System.out.println("кількість чисел у рівнянні: "
                                + inputHandler.howManyNumbersAreInTheEquation(str));
                    }
                }

                case 2 -> {
                    break loop;
                }
            }
        }
    }

}