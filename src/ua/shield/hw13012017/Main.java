package ua.shield.hw13012017;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by sa on 12.01.17.
 */
public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number;
        Main main = new Main();

        System.out.println("Сумма от 1 до N:");
        System.out.println("Введите N");
        number = main.scanner.nextInt();
        System.out.println("Сумма от 1 до " + number + "=" + main.getSumFromOneToNumber(number));
        System.out.println();

        System.out.println("Печать символа N раз");
        System.out.println("Введите число");
        number = main.scanner.nextInt();
        System.out.println("Введите символ");
        char symbol = main.scanner.next().charAt(0);
        main.printSymbol(number, symbol);
        System.out.println();

        System.out.println("Степень числа:");
        System.out.println("Введите число");
        number = main.scanner.nextInt();
        System.out.println("Введите степень");
        int pow = main.scanner.nextInt();
        System.out.println(main.pow(number, pow));
        System.out.println();

        System.out.println("Максимальный делитель:");
        System.out.println("Введите 1-е число");
        int a = main.scanner.nextInt();
        System.out.println("Введите 2-е число");
        int b = main.scanner.nextInt();
        System.out.println("НОД(" + a + "," + b + ")=" + main.getMaxDivisor(a, b));
        System.out.println();

        System.out.println("Четна ли сумма цифр числа?");
        System.out.println("Введите число");
        number = main.scanner.nextInt();
        System.out.println(main.isSummOfDigitEven(number));
        System.out.println();


        System.out.println("Верно ли, что числа в числе стоя по возрастанию?");
        System.out.println("Введите число");
        number = main.scanner.nextInt();
        System.out.println(main.isIncreaseDigit(number));
        System.out.println();
    }

    /**
     * Сумма от 1 до number
     *
     * @param number -число до которого считается сумма
     * @return -сумма
     */
    BigInteger getSumFromOneToNumber(int number) {
        BigInteger result;
        BigInteger a = BigInteger.valueOf(number);
        result = a.multiply(a.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
        return result;

    }

    /**
     * Печать символа number раз
     *
     * @param number -кол-во раз
     * @param symbol -символ для печати
     */

    void printSymbol(int number, char symbol) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stringBuilder.append(symbol);
        }
        System.out.println(stringBuilder);
    }

    /**
     * Считаем степень числа
     *
     * @param number -число
     * @param p      -степень
     * @return степень p числа number
     */
    double pow(double number, double p) {
        return Math.pow(number, p);
    }

    /**
     * Находим наибольший общий делитель двух чисел
     *
     * @param a -число 1
     * @param b -число 2
     * @return НОД
     */
    int getMaxDivisor(int a, int b) {
        int maxDivisor = 1;
        for (int i = 2; i <= (a > b ? b : a); i++) {
            if (a % i == 0 && b % i == 0) {
                maxDivisor = i;
            }
        }
        return maxDivisor;
    }

    /**
     * Проверяем сумму цифр числа
     *
     * @param number -число
     * @return true-четная сумма иначе false
     */
    boolean isSummOfDigitEven(int number) {
        int summ = 0;
        number = (number > 0) ? number : number * -1;//делаем из отрицательного числа положительное
        while (number > 0) {
            summ += number - number / 10 * 10;
            number = number / 10;
        }
        if (summ % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Проверяем, все ли цифры в числе по возрастанию;
     *
     * @param number -число
     * @return true-если по возрастанию, false-нет
     */
    boolean isIncreaseDigit(int number) {
        number = (number > 0) ? number : number * -1; //делаем из отрицательного числа положительное
        int lastDigit = number - number / 10 * 10; //берем последнюю цифру
        number = number / 10;
        if (number == 0) return false; //если число из одной цифры, то false
        int prevDigit;
        while (number > 0) {
            prevDigit = number - number / 10 * 10;
            if (prevDigit > lastDigit) {
                return false;
            }
            number = number / 10;
            lastDigit = prevDigit;
        }
        return true;
    }

}
