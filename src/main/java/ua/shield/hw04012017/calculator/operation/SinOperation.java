package ua.shield.hw04012017.calculator.operation;

/**
 * Created by sa on 05.01.17.
 */

/**
 * Операция Sin
 */
public class SinOperation extends AbstractOperation implements IOperation {

    @Override
    public float run(float result) {
        prevResult = result;
        return (float) Math.sin(result);
    }

    @Override
    public String toString() {
        return "sin";
    }
}
