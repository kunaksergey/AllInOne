package ua.shield.hw18012017;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sa on 19.01.17.
 */
public class Main {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.oneTask();
        main.twoTask();
    }
    /**
     * Первое задание:
     * Заполнить массив из 10 элементов случайными числами в интервале[0..100] и отсортировать первую половину
     * по возрастанию, вторую по убыванию
     */
    void oneTask() {
        System.out.println("Сортировка одной половины по возрастанию,другой по убыванию ");
        int[] arr = IntStream.range(0, 10).map(e -> random.nextInt(100) + 1).toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortOfMiddleArray(arr)));
    }

    /**
     * Второе задание:
     * Написать программу,которая сортирует массив по УБЫВАНИЮ и ищет в нем элемент, равный Х
     * (это число вводится с клавиатуры)
     */
    void twoTask() {
        System.out.println("Поиск эллемента в массиве");
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] arr = IntStream.range(0, size).map(e -> random.nextInt(100) + 1).toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println("Введите число для поиска:");
        int number = scanner.nextInt();
        System.out.println("Отсортированный массив по убыванию:");
        int[] arrSort = sortIntegerArray(arr, new FromMaxToMinSortStrategy());
        System.out.println(Arrays.toString(arrSort));
        System.out.println("Результат для числа: " + number+" в отсортированном массиве");
        System.out.println(Arrays.toString(sortIntegerArray(indexElementInArray(arrSort, number), new FromMinToMaxSortStrategy())));
    }


    /**
     * Сортировка от середины массива
     * @param arr
     * @return
     */
    public int[] sortOfMiddleArray(int[] arr) {
        int nMin, nMax, tmp;
        int middleOfArray = arr.length / 2;

        for (int i = 0; i < middleOfArray - 1; i++) {
            nMin = i;
            nMax = i + middleOfArray;
            for (int j = i + 1; j < middleOfArray; j++) {
                if ((arr[j]) < (arr[nMin])) {
                    nMin = j;
                }
                if ((arr[j + middleOfArray]) > (arr[nMax])) {
                    nMax = j + middleOfArray;
                }
            }
            if (nMin != i) {
                tmp = arr[i];
                arr[i] = arr[nMin];
                arr[nMin] = tmp;
            }
            if (nMax != i + middleOfArray) {
                tmp = arr[i + middleOfArray];
                arr[i + middleOfArray] = arr[nMax];
                arr[nMax] = tmp;
            }
        }
        return arr;
    }

    /**
     * Получение массива индексов вхождения числа в отсортированный массив
     * @param arr    входящий массив
     * @param number -число для поиска
     * @return массив индексов числа, входящего в начальный массив
     */
    public int[] indexElementInArray(final int[] arr, final int number) {
        int[] arrTmp = arr;
        int[] result = Arrays.stream(arrTmp).map(e -> -1).toArray();//массив длиной arr.lenght забитый -1;
        int indexResult = 0;//начальная позиция маркера результата
        int left = 0; //левая граница
        int right = arrTmp.length - 1;//правая граница
        int c;
        while (right >= left) {
            c = (right + left) / 2;
            if (number < arrTmp[c]) left = c + 1;
            if (number > arrTmp[c]) right = c - 1;

            if (number == arrTmp[c]) {
                result[indexResult] = c;
                indexResult++;
                int leftIndexResult, rightIndexResult;
                leftIndexResult = rightIndexResult = c;
                //Двигаемся вправо в отсортированном массиве и ищем наш елемент
                while (rightIndexResult + 1 < arrTmp.length && arrTmp[rightIndexResult + 1] == number) {
                    result[indexResult] = rightIndexResult + 1;
                    indexResult++;
                    rightIndexResult++;
                }
                //Двигаемся влево в отсортированном массиве и ищем наш елемент
                while (leftIndexResult - 1 >= 0 && arrTmp[leftIndexResult - 1] == number) {
                    result[indexResult] = leftIndexResult - 1;
                    indexResult++;
                    leftIndexResult--;
                }
                break;
            }
        }

        return Arrays.copyOfRange(result, 0, indexResult);
    }

    /**
     * Сортировка массива
     *
     * @param arr
     * @param sortStrategy new FromMinToMaxSortStrategy()-сортировка по возрастанию,
     *                     new FromMaxToMinSortStrategy()- сортировка по убыванию,
     * @return отсортированный массив
     */
    public int[] sortIntegerArray(int[] arr, SortStrategy sortStrategy) {
        int tmp;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortStrategy.isCondition(arr[j], arr[j + 1])) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}

/**
 * Интерфейс для стретегии
 */
interface SortStrategy {
    boolean isCondition(int a, int b);
}

/**
 * Стратегия сортировки по возрастанию
 */
class FromMinToMaxSortStrategy implements SortStrategy {
    @Override
    public boolean isCondition(int a, int b) {
        if (a > b) {
            return true;
        }
        return false;
    }
}

/**
 * Стратегия сортировки по убыванию
 */
class FromMaxToMinSortStrategy implements SortStrategy {
    @Override
    public boolean isCondition(int a, int b) {
        if (a < b) {
            return true;
        }
        return false;
    }
}