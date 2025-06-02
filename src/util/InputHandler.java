package util;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static long getLong(String prompt) {
        System.out.print(prompt);
        return scanner.nextLong();
    }

    public static int getInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static double getDouble(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static void nextLine() {
        scanner.nextLine();
    }
}
