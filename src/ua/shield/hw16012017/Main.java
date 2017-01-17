package ua.shield.hw16012017;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by sa on 16.01.17.
 */
public class Main {
    static private Random random = new Random();

    public static void main(String[] args) {
        System.out.println(summOfSquaresTwoNumbers(5, 5));
        try {
            System.out.println(Arrays.toString(getFildedArray(10)));
        } catch (NotRigthSizeArrayExeption notRigthSizeArrayExeption) {
            notRigthSizeArrayExeption.printStackTrace();
        }
    }

    /**
     * @param a   -число типа Number
     * @param b   --число типа Number
     * @param <T> -тип чисел
     * @return a*a+b*b
     */
    //НЕ понято,почему не отбрасывается дробная часть при Integer!!!
    static <T extends Number> T summOfSquaresTwoNumbers(T a, T b) {
        Double summ = a.doubleValue() * a.doubleValue() + b.doubleValue() * b.doubleValue();
        return (T) summ;
    }

    /**
     * @param size -размер массива
     */
    static int[] getFildedArray(final int size) throws NotRigthSizeArrayExeption {
        if (size < 1) throw new NotRigthSizeArrayExeption("Size is not right");
        return getFildedArray(null, size);
    }

    /**
     * @param arr начальный мыссив
     * @return массив длинной N,без повторяющихся элементов с позиции arr.length до N-1
     */
    static int[] getFildedArray(final int[] arr, final int size) {
        int[] sourceArr = arr;
        if (sourceArr == null) {
            sourceArr = new int[1];
            sourceArr[0] = random.nextInt(200) - 100;
            sourceArr = getFildedArray(sourceArr, size);
        } else if (sourceArr.length < size) {
            int value = random.nextInt(100);
            if (isNotRepatedDigit(sourceArr, value)) {
                int[] destArr = new int[sourceArr.length + 1];
                System.arraycopy(sourceArr, 0, destArr, 0, sourceArr.length);
                destArr[destArr.length - 1] = value;
                sourceArr = destArr;
            }
            sourceArr = getFildedArray(sourceArr, size);
        }
        return sourceArr;
    }

    /**
     * @param arr          -массив
     * @param curentNumber -число
     * @return если число НЕ встречается:true, иначе false
     */
    static boolean isNotRepatedDigit(int[] arr, int curentNumber) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == curentNumber) {
                return false;
            }
        }
        return true;
    }

    private static class NotRigthSizeArrayExeption extends Exception {
        public NotRigthSizeArrayExeption(String message) {
            super(message);
        }
    }
}


