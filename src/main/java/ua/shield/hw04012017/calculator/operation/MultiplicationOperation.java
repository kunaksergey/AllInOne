package ua.shield.hw04012017.calculator.operation;

/**
 * Created by sa on 05.01.17.
 */

/**
 * Операция умножения
 */
public class MultiplicationOperation extends AbstractOperation implements IOperation {

    @Override
    public float run(float result) {
        prevResult = result;
        System.out.println("Введите число:");
        Float value = scanner.nextFloat();
        return result * value;
    }

    @Override
    public String toString() {
        return "/";
    }
}
