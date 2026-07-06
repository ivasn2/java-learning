/*
 * Создать программу-калькулятор, которая выполняет базовые арифметические операции с использованием методов
 *
 * Что должно делать приложение:

        1) Программа запускается в консоли и:
        2) Просит пользователя ввести первое число
        3) Просит ввести оператор:
                +, -, *, /
        4) Просит ввести второе число
        5) Выполняет вычисление
        6) Выводит результат на экран

 */
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scn.nextInt();

        System.out.print("Введите оператор (+, -, *, /): ");
        String operator = scn.next();

        System.out.print("Введите второе число: ");
        int num2 = scn.nextInt();

        switch (operator) {
            case "+":
                System.out.println("Результат: " + add(num1, num2));
                break;

            case "-":
                System.out.println("Результат: " + subtract(num1, num2));
                break;

            case "*":
                System.out.println("Результат: " + multiply(num1, num2));
                break;

            case "/":
                if (num2 == 0) {
                    System.out.println("На ноль делить нельзя!");
                }
                System.out.println("Результат: " + divide(num1, num2));
                break;

            default:
                System.out.println("Неправильный ввод!");
        }

        scn.close();
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }


}
