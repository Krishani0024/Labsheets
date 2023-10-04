import java.util.Scanner;

class Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}

class CommandLineCalculator {
    private Calculator calculator;
    private Scanner scanner;

    public CommandLineCalculator() {
        calculator = new Calculator();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Command-Line Calculator!");
        System.out.println("Available operations: +, -, *, /");

        while (true) {
            double num1 = getNumberInput("Enter the first number: ");
            String operation = getOperationInput("Enter the operation (+, -, *, /): ");
            double num2 = getNumberInput("Enter the second number: ");

            double result;

            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    try {
                        result = calculator.divide(num1, num2);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
                    continue;
            }

            System.out.println("Result: " + result);

            String anotherCalculation = getStringInput("Do you want to perform another calculation? (yes/no): ");
            if (!anotherCalculation.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for using the calculator!");
        scanner.close();
    }

    private double getNumberInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private String getOperationInput(String message) {
        System.out.print(message);
        String operation = scanner.next();
        while (!isValidOperation(operation)) {
            System.out.print("Invalid operation. Please enter +, -, *, or /: ");
            operation = scanner.next();
        }
        return operation;
    }

    private boolean isValidOperation(String operation) {
        return "+".equals(operation) || "-".equals(operation) || "*".equals(operation) || "/".equals(operation);
    }

    private String getStringInput(String message) {
        System.out.print(message);
        return scanner.next().toLowerCase();
    }
}

public class Calculator3 {
    public static void main(String[] args) {
        CommandLineCalculator calculator = new CommandLineCalculator();
        calculator.start();
    }
}