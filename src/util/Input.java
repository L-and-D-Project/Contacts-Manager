package util;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        String s = scanner.nextLine();
        return s;
    }

    public String getString(String specialMessage) {
        System.out.println(specialMessage + "\n");
        String s = scanner.nextLine();
        return s;
    }

    public boolean yesNo() {
        String s = scanner.nextLine();
        return (s.toUpperCase().startsWith("Y"));
    }

    public boolean yesNo(String specialMessage) {
        System.out.println(specialMessage);
        String s = scanner.nextLine();
        return (s.toUpperCase().startsWith("Y"));
    }

    public int getInt(int min, int max) {
        System.out.print("Please enter a whole number between " + min + " and " + max + ": ");
        int newInput = getInt();
        if (newInput < min || newInput > max) {
            newInput = getInt(min, max);
        }
        return newInput;
    }

    public int getInt(int min, int max, String specialMessage) {
        System.out.println(specialMessage);
        int newInput = getInt();
        if (newInput < min || newInput > max) {
            newInput = getInt(min, max);
        }
        return newInput;
    }

    private int getInt() {
        int newInt = 0;
        try {
            newInt = Integer.valueOf(getString());
        } catch (Exception e) {
            System.out.println("Invalid format. Please try again.");
            newInt = getInt();
        }
        return newInt;
    }

    public double getDouble(double min, double max) {
        System.out.print("Please enter a decimal between " + min + " and " + max + ": ");
        double newInput = getDouble();
        if (newInput < min || newInput > max) {
            newInput = getDouble(min, max);
        }
        System.out.println();
        return newInput;
    }

    public double getDouble(double min, double max, String specialMessage) {
        System.out.println(specialMessage);
        double newInput = getDouble();
        if (newInput < min || newInput > max) {
            newInput = getDouble(min, max);
        }
        return newInput;
    }

    private double getDouble() {
        double newDouble = 0.0;
        try {
            newDouble = Double.valueOf(getString());
        } catch (Exception e) {
            System.out.println("Invalid format. Please try again.");
            newDouble = getDouble();
        }
        return newDouble;
    }

    public int getBinary() {
        System.out.println("Please enter a binary number.");
        int binary = 0;
        try {
            binary = Integer.valueOf(getString(), 2);
        } catch (Exception e) {
            System.out.println("Invalid format. Please try again.");
            binary = getInt();
        }
        return binary;
    }

    public int getHex() {
        System.out.println("Please enter a hexidecimal number.");
        int hexi = 0;
        try {
            hexi = Integer.valueOf(getString(), 16);
        } catch (Exception e) {
            System.out.println("Invalid format. Please try again.");
            hexi = getInt();
        }
        return hexi;
    }
}
