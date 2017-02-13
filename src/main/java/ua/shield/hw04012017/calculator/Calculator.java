package ua.shield.hw04012017.calculator;

import ua.shield.hw04012017.calculator.operation.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sa on 05.01.17.
 */

/**
 * Калькулятор
 */
public class Calculator {
    private float result = 0; //начальное значение
    private Stack<IOperation> operationStack = new Stack<>(); //стек операций
    private final static Scanner scanner = new Scanner(System.in);

    public Calculator() {
        init();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    /**
     * Добавляем классы операций в фабрику
     */
    private void init() {
        FactoryOperation.addOpperation("+", PlusOperation.class);
        FactoryOperation.addOpperation("-", SubOperation.class);
        FactoryOperation.addOpperation("*", MultiplicationOperation.class);
        FactoryOperation.addOpperation("/", DevisionOperation.class);
        FactoryOperation.addOpperation("cos", CosOperation.class);
        FactoryOperation.addOpperation("sin", SinOperation.class);
    }

    public void showOperation() {
        System.out.println("c-очистка:");
        System.out.println("z-отмена:");
        System.out.println("x-выход:");
        System.out.println("Операции:");
        FactoryOperation.printSupportOperation();
    }

    /**
     * печать результата
     */
    public void printResult() {
        System.out.println(result);
    }

    public void run() throws InstantiationException, IllegalAccessException {
        String currentOperation;
        showOperation();
        try {
            printResult();
            System.out.println("Введите число:");
            result = scanner.nextFloat();
        } catch (InputMismatchException e) {
            return;
        }
        while (true) {
            System.out.println("Введите операцию или x-Выход,z-Отмена,c-Очистка:");
            currentOperation = scanner.next();

            if (currentOperation.equals("x")) {
                break;
            } else if (currentOperation.equals("z") && operationStack.size() != 0) {
                result = operationStack.pop().cancel();
            } else if (currentOperation.equals("c")) {
                result = 0;
                operationStack.clear();
            } else {
                try {
                    IOperation operation = FactoryOperation.getOperation(currentOperation);
                    result = operation.run(result);
                    operationStack.push(operation);
                } catch (OperationIsNotSupportException e) {
                    System.out.println("Операция не поддерживается");
                }
            }
            printResult();
        }

    }
}