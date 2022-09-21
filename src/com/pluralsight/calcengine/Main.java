package com.pluralsight.calcengine;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 255.0d, 110.0d};
        double[] rightVals = {130.0d, 65.0d, 55.0d, 33.0d};
        char[] opCodes = {'a', 's', 'm', 'd'};
        double[] results = new double[opCodes.length];


        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);

            }

            for (double currentResult : results)
                System.out.println(currentResult);
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeIneractively();
        } else if (args.length == 3) {
            handelComandLine(args);
        } else {
            System.out.println("Must put numbers in comand line thank you");
        }
    }

    static void executeIneractively() {
        System.out.println("Enter  add,subtact,multiply,or divide and two numbers ");
        Scanner scanner = new Scanner(System.in);
        String userInput =scanner.nextLine();
        String[] parts =  userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result = execute(opCode,leftVal, rightVal);
        displayResult(opCode, leftVal, rightVal, result);
        System.out.println(result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
//        StringBuilder builder = new StringBuilder(20);
//        builder.append(leftVal);
//        builder.append(" ");
//        builder.append(symbol);
//        builder.append(" ");
//        builder.append(rightVal);
//        builder.append(" = ");
//        builder.append(result);
//        String output = builder.toString();
//
//
        String output = String.format("%f %c %f = %f", leftVal, symbol, rightVal, result);
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int index = 0; index < opCodes.length; index++) {
            if(opCode == opCodes[index]) {
                symbol = symbols[index];
                break;
            }
        }

        return symbol;
    }
    private static void handelComandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);


    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {

            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal + rightVal;
                break;
            case 'm':
                result = leftVal + rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                result = 0.0d;
                System.out.println("Invalid opCode" + opCode);
                break;
        }
        return result;
    }

    ;

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four","five", "six", "seven", "eight", "nine", "ten"
        };
        double value = 0d;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        return value;
    }
}
