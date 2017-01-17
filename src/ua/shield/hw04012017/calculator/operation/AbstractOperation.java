package ua.shield.hw04012017.calculator.operation;

import ua.shield.hw04012017.calculator.Calculator;

import java.util.Scanner;

/**
 * Created by sa on 05.01.17.
 */

/**
 * Абстрактный класс операций
 */
public abstract class AbstractOperation implements IOperation{
    float prevResult; //предыдущий результат
    Scanner scanner= Calculator.getScanner();

    /**
    * @return предыдущий результат
     */
    @Override
    public float cancel() {
        return prevResult;
    }
}
