package ua.shield.hw28122016.task;

import ua.shield.hw28122016.annotation.DefAnnotation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by sa on 01.01.17.
 */

@DefAnnotation(desc = "Циклы")
public class CycleOperation {
    Scanner scanner = new Scanner(System.in);

    @DefAnnotation(desc = "Вывести на консоль изображение государственного флага Швейцарии\n" +
            "(например, в виде звездочек). Размер стороны флага задается случайным\n" +
            "числом в диапазоне от 21 до 41.")
    public void taskOne() {
        String singCross = "*";
        String singCanvas = "-";
        StringBuffer stringBuffer = new StringBuffer();
        int border = 2;
        int weightFlag = (int) (21 + Math.random() * 21);
        System.out.println("Ширина флага:" + weightFlag);
        int weightCross = weightFlag / 5;
        int weightHalfCanvasWithoutCross = (weightFlag - weightCross) / 2;
        for (int i = 0; i < weightFlag; i++) {
            for (int j = 0; j < weightFlag; j++) {
                if (i < border || i >= weightFlag - border || j < border || j >= weightFlag - border) {
                    stringBuffer.append(singCanvas);
                } else if (i >= weightHalfCanvasWithoutCross && i <= weightHalfCanvasWithoutCross + weightCross) {
                    stringBuffer.append(singCross);
                } else {
                    if (j >= weightHalfCanvasWithoutCross && j <= weightHalfCanvasWithoutCross + weightCross) {
                        stringBuffer.append(singCross);
                    } else {
                        stringBuffer.append(singCanvas);
                    }
                }
            }
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer);
    }

    @DefAnnotation(desc = "Напечатать ряд чисел 20 в виде: 20 20 20 20 20 20 20 20 20 20.")
    public void taskTwo() {
        printNumberOfTimes(20, 10);
    }

    @DefAnnotation(desc = "Составить программу вывода любого числа любое заданное число раз в\n" +
            "виде, аналогичном показанному в предыдущей задаче.")
    public void taskThree() {
        System.out.println("Введите число для вывода:");
        int number = scanner.nextInt();
        System.out.println("Введите количество раз,сколько надо вывести число:");
        int timeOfPrint = scanner.nextInt();
        printNumberOfTimes(number, timeOfPrint);
    }

    @DefAnnotation(desc = "Одна штука некоторого товара стоит 20,4 руб. Напечатать таблицу\n" +
            "стоимости 2, 3, ..., 20 штук этого товара.")
    public void taskFour() {
        float ratio = 20.4f;
        String strFormat= " штук(и) товара: %.2f руб.%n";
        printTableRation(ratio,20,strFormat);
    }

    @DefAnnotation(desc = "Напечатать таблицу соответствия между весом в фунтах и весом в\n" +
            "килограммах для значений 1, 2, ..., 10 фунтов (1 фунт = 453 г).")
    public void taskFive() {
        float ratio = 0.453f;
        String strFormat= " фунт(ов)= %.3f кг.%n";

        printTableRation(ratio,10,strFormat);
    }

    @DefAnnotation(desc = "Напечатать таблицу перевода 1, 2, ... 20 долларов США в рубли по текущему\n" +
            "курсу (значение курса вводится с клавиатуры).")
    public void taskSix() {
        StringBuffer stringBuffer = new StringBuffer();
        String strFormat=" $=%.2f руб.\n";
        System.out.println("Введите курс рубля к $ ");
        float ratio = scanner.nextFloat();
        printTableRation(ratio,20,strFormat);
    }

    @DefAnnotation(desc = "Напечатать таблицу умножения на 7:")
    public void taskSeven() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 9; i++) {
            stringBuffer.append(i + "x7=" + i * 7 + "\n");
        }
        System.out.println(stringBuffer);
    }

    @DefAnnotation(desc = "Напечатать таблицу стоимости 100, 200, 300, ..., 2000 г конфет (стоимость 1\n" +
            "кг конфет вводится с клавиатуры).")
    public void taskEight() {
        System.out.println("Введите стоимость кг. конфет:");
        float cost = scanner.nextFloat();
        for (int i = 1; i <= 20; i++) {
            System.out.printf("Стоимость %dг. конфет: %.2f%n", i * 100, cost / 10 * i);
        }
    }

    @DefAnnotation(desc = "Найти сумму всех целых чисел от –10 до b (значение b вводится с\n" +
            "клавиатуры; b >= –10")
    public void taskNine() {
        System.out.println("Введите целое число b>=-10");
        int summ = 0;
        int number = scanner.nextInt();
        for (int i = -10; i <= number; i++) {
            summ += i;
        }
        System.out.println("Сумма всех целых чисел от –10 до " + number + ":" + summ);
    }

    @DefAnnotation(desc = "Найти среднее арифметическое всех целых чисел от 1 до 1000;")
    public void taskTen() {
        System.out.println(average(1, 1000));
    }

    @DefAnnotation(desc = "Найти среднее арифметическое всех целых чисел от a до b (значения a и b\n" +
            "вводятся с клавиатуры; b >= a).")
    public void taskEleven() {
        System.out.println("Введите целое а");
        int a = scanner.nextInt();
        System.out.println("Введите целое b");
        int b = scanner.nextInt();
        System.out.println(average(a, b));
    }

    @DefAnnotation(desc = "Вычислить сумму: 2/3+3/4+4/5...+10/11")
    public void taskTwelve() {
        float summ = 0;
        for (int i = 2; i <= 10; i++) {
            summ += (float) (i * 1.0 / (i + 1) * 1.0);
        }
        System.out.println("Сумма 2/3+/4+4/5...+10/11:" + summ);
    }

    @DefAnnotation(desc = "Известны оценки ученика по 10 предметам. Определить среднюю оценку.")
    public void taskThirteen() {
        int result = 0;
        int[] gradArr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            gradArr[i] = random.nextInt(gradArr.length) + 1;
        }
        for (int i = 0; i < gradArr.length; i++) {
            result += gradArr[i];
        }
        System.out.println("Оценки ученика:" + Arrays.toString(gradArr));
        System.out.println("Средняя оценка ученика:" + result / gradArr.length);
    }

    @DefAnnotation(desc = "Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,\n" +
            "сколько клеток будет через 3, 6, 9, ..., 24 часа, если первоначально была\n" +
            "одна амеба.")
    public void taskFourteen() {
        for (int i = 1; i <= 8; i++) {
            System.out.println("Через " + (i * 3) + "ч.:" + (int) Math.pow(2, i) + " амеб");
        }
    }

    @DefAnnotation(desc = "Найти сумму 2^2+2^3+2^4..+2^10. Операцию возведения в степень не использовать:")
    public void taskFiveteen() {
        int prev = 2;
        int summ = 0;
        for (int i = 2; i <= 10; i++) {
            prev = prev * 2;
            summ = summ + prev;
        }
        System.out.println("Сумма 2^2+2^3+2^4..+2^10:" + summ);
    }

    @DefAnnotation(desc = "Последовательность Фибоначчи образуется так: первый и второй члены\n" +
            "последовательности равны 1, каждый следующий равен сумме двух\n" +
            "предыдущих (1, 1, 2, 3, 5, 8, 13, ...). Дано натуральное число n (n >= 3)." +
            "а) Найти k-й член последовательности Фибоначчи.\n" +
            "б) Получить первые n членов последовательности Фибоначчи.\n" +
            "в) Верно ли, что сумма первых n членов последовательности Фибоначчи\n" +
            "есть\n" +
            "четное число? ")
    public void taskSixteen() {
        System.out.println("Ввведите n>=3 для формирования ряда Фибоначчи");
        int sizeFibonachi = scanner.nextInt();
        int[] arrFibonachi = new int[sizeFibonachi];
        arrFibonachi[0] = arrFibonachi[1] = 1;
        for (int i = 2; i < sizeFibonachi; i++) {
            arrFibonachi[i] = arrFibonachi[i - 1] + arrFibonachi[i - 2];
        }
        int randomK = (int) (Math.random() * sizeFibonachi);
        System.out.println("Ряд фибоначи: " + Arrays.toString(arrFibonachi));
        System.out.println(randomK + "-й член ряда Фибоначчи:" + arrFibonachi[randomK]);
        System.out.println("Введите n>=0 и <=" + sizeFibonachi);
        int n = scanner.nextInt();
        int summ = 0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Первые " + n + "членов последовательности:\n");
        for (int i = 0; i < n; i++) {
            summ += arrFibonachi[i];
            stringBuffer.append(arrFibonachi[i]).append(" ");
        }
        stringBuffer.append("\n");
        if (summ % 2 == 0) {
            stringBuffer.append("Сумма первых ").append(n).append(" членов последовательности есть четное число:").append(summ);
        } else {
            stringBuffer.append("Сумма первых ").append(n).append(" членов последовательности есть не четное число:").append(summ);
        }
        System.out.println(stringBuffer);
    }

    @DefAnnotation(desc = "*Найти сумму: -1^2+2^2-3^2+4^2...+10^2. Условный оператор не использовать.")
    public void taskSeventeen() {
        int sing = -1;
        int result = 0;
        for (int i = 1; i <= 10; i++) {
            result = result + i * i * sing;
            sing = sing * -1;
        }
        System.out.println(result);
    }

    @DefAnnotation(desc = "Даны натуральные числа х и у. Вычислить произведение xy, используя\n" +
            "лишь операцию сложения. Задачу решить двумя способами.")
    public void taskEighteen() {
        int result = 0;
        System.out.println("Ввведите число x:");
        int x = scanner.nextInt();
        System.out.println("Ввведите число y:");
        int y = scanner.nextInt();
        for (int i = 1; i <= y; i++) {
            result += x;
        }
        System.out.println("Произведение xy=" + result);
    }

    @DefAnnotation(desc = "Составить программу для расчета факториала натурального числа n\n" +
            "(факториал числа n равен 1 2 ... n ).")
    public void taskNineteen() {
        int result = 1;
        System.out.println("Введите натуральное число:");
        int number = scanner.nextInt();
        if (number != 0) {
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
        }
        System.out.println("Факториал числа " + number + "! =" + result);
    }

    @DefAnnotation(desc = "Вывести на экран все целые числа от 100 до 200, кратные трем.")
    public void taskTwenty() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 100; i <= 200; i++) {
            if (i % 3 == 0) {
                stringBuffer.append(i).append(" ");
            }
        }
        System.out.println(stringBuffer);
    }

    @DefAnnotation(desc = "Составить программу поиска трехзначных чисел, которые при делении на 47\n" +
            "дают в остатке 43, а при делении на 43 дают в остатке 47.")
    public void taskTwentyOne() {
        System.out.println("Программа не имеет решений,поскольку остаток не может быть больше делителя");
    }

    @DefAnnotation(desc = "Даны вещественные числа b1, b2, ..., b8. Определить количество тех из\n" +
            "них, которые меньше 100.")
    public void taskTwentyTwo() {
        int count = 0;
        double[] arrayOfDouble = genArrayOfDouble(8);
        for (int i = 0; i < 8; i++) {
            if (arrayOfDouble[i] < 100) {
                count++;
            }
        }
        System.out.println("Кол-во вещественных чисел в массиве:" + Arrays.toString(arrayOfDouble) +
                " и которые<100: " + count);
    }

    @DefAnnotation(desc = "Даны натуральное число n и вещественные числа x ,1x ,2..., xn. Найти коли-\n" +
            "чество вещественных чисел, которые больше своих \"соседей\", т. е.\n" +
            "предшествующего и последующего.")
    public void taskTwentyThree() {
        int count = 0;
        System.out.println("Введите кол-во чисел:");
        int n = scanner.nextInt();
        double[] arrayOfDouble = genArrayOfDouble(n);
        for (int i = 1; i < arrayOfDouble.length - 1; i++) {
            if (arrayOfDouble[i] > arrayOfDouble[i - 1] && arrayOfDouble[i] > arrayOfDouble[i + 1]) {
                count++;
            }
        }
        System.out.println("Сгеннерированный массив:" + Arrays.toString(arrayOfDouble));
        System.out.println("Кол-во чисел которые больше своих \"соседей\":" + count);
    }

    @DefAnnotation(desc = "Найти количество делителей каждого из целых чисел от 120 до 140.")
    public void taskTwentyFour() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Число:делителей\n");
        int count;
        for (int i = 120; i <= 140; i++) {
            count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            stringBuffer.append(i).append(": ").append(count).append("\n");
        }
        System.out.println(stringBuffer);
    }

    @DefAnnotation(desc = "Найти все трехзначные простые числа (простым называется натуральное\n" +
            "число, большее 1, не имеющее других делителей, кроме единицы и самого\n" +
            "себя).")
    public void taskTwentyFive() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Трехзначные простые числа:");
        for (int i = 100; i < 999; i++) {
            if (isSimpleNumber(i)) {
                stringBuffer.append(i).append(" ");
            }
        }
        System.out.println(stringBuffer);
    }

    @DefAnnotation(desc = "Натуральное число называется совершенным, если оно равно сумме своих\n" +
            "делителей, включая 1 и, естественно, исключая это самое число. Например,\n" +
            "совершенным является число 6 ( 6 1 2 3). Найти все совершенные\n" +
            "числа, меньшие 100 000.")
    public void taskTwentySix() {
        StringBuffer stringBuffer=new StringBuffer();
        int topBorder=100000;
        int summ;
        for(int i=1;i<=topBorder;i++){
            summ=0;
            if(i%2!=0){ //нечетных совершенных чисель пока не обнаружено
                continue;
            }
            for(int j=1;j<=i/2;j++){
                if(summ>i) break;
                if(i%j==0){
                    summ+=j;
                }
            }
            if (i==summ){
                stringBuffer.append(i).append(" ");
            }
        }
        System.out.println(stringBuffer);
    }

    /**
     *
     * @param number -число
     * @param times -сколько раз его напечатать
     */
    private void printNumberOfTimes(int number, int times) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < times - 1; i++) {
            stringBuffer.append(number).append(" ");
        }
        stringBuffer.append(number);
        System.out.println(stringBuffer);
    }

    /**
     * @param number -целое число
     * @return если число натуральное, то true, иначе false
     */
    private boolean isSimpleNumber(int number) {
        if (number == 2) return true;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param a -первое число
     * @param b - второе число
     * @return -среднее арифметическое
     */
    private double average(int a, int b) {
        if (a > b) {
            b = a + b;
            a = b - a;
            b = b - a;
        }
        int average = 0;
        for (int i = a; i <= b; i++) {
            average += i;
        }
        return new BigDecimal(average).floatValue() / new BigDecimal(b).floatValue();
    }

    /**
     * @param n кол-во генерируемых чисел
     * @return массив типа double, заполненных через random
     */
    private double[] genArrayOfDouble(int n) {
        double[] arrayOfDouble = new double[n];
        System.out.println("Введите интервал генерации вещественных чисел:");
        System.out.println("min:");
        int min = scanner.nextInt();
        System.out.println("max:");
        int max = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arrayOfDouble[i] = Math.random() * (max - min) + min;
        }
        return arrayOfDouble;
    }

    /**
     *
     * @param ratio -текущий курс
     * @param topBorder -верхняя граница
     * @param strFormat -форматированная строка
     */
    private void printTableRation(float ratio,int topBorder,String strFormat){
        for (int i = 1; i <= topBorder; i++) {
            System.out.printf(i + strFormat, i * ratio);
        }
    }
}
