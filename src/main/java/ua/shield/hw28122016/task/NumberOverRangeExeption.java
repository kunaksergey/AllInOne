package ua.shield.hw28122016.task;

/**
 * Created by sa on 02.01.17.
 */
public class NumberOverRangeExeption extends Exception {
    public NumberOverRangeExeption() {
        super("Число вышло за пределы возможного диапазона");
    }
}
