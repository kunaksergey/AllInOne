package ua.shield.hw04012017.calculator.operation;

/**
 * Created by sa on 05.01.17.
 */

/**
 * Операция Cos
 */
public class CosOperation extends AbstractOperation implements IOperation {

    @Override
    public float run(float result) {
        prevResult = result;
        return (float) Math.cos(result);
    }

    @Override
    public String toString() {
        return "cos";
    }
}
