package ua.shield.hw28122016.task;

import ua.shield.hw28122016.annotation.DefAnnotation;

import java.util.Scanner;

/**
 * Created by sa on 30.12.16.
 */
@DefAnnotation(desc="Арифметические операции")
public class ArifmeticOperation {
    Scanner scanner=new Scanner(System.in);

    @DefAnnotation(desc = "Спросить у пользователя сумму покупки и узнать его скидку." +
            "Выдать результат- \"К оплате с учетом скидки\"")
    public void taskOne(){
        double summ,result;
        int discount;
        System.out.println("Введите сумму:");
        summ=scanner.nextDouble();
        System.out.println("Ваша скидка в %:");
        discount=scanner.nextInt();
        result=summ-summ*discount/100;
        System.out.printf("Итого к оплате:,%.2f%n",result);

    }

    @DefAnnotation(desc = "Ввести три числа и найти наибольшее из них")
    public void taskTwo() {
        System.out.println("Введите 3 целых числа разделенные пробелом");
        String[] strArr = scanner.nextLine().split(" ", 3);
        int max=Integer.parseInt(strArr[0]);
        for (int i = 1; i < 3; i++) {
            if(Integer.parseInt(strArr[i])>max){
                max=Integer.parseInt(strArr[i]);
            }
        }
        System.out.println("Наибольшее число: "+max);
    }


    @DefAnnotation(desc = "Ввести пять чисел и найти среднее арифметиеское")
    public void TaskThree(){
    double result;
        System.out.println("Введите 5 целых числа разделенные пробелом");
        String[] strArr = scanner.nextLine().split(" ", 5);
        int summ=0;
        for (int i = 0; i < 5; i++) {
           summ+=Integer.parseInt(strArr[i]);
        }
        System.out.println("Среднее арифметическое: "+summ/strArr.length);
    }


}
