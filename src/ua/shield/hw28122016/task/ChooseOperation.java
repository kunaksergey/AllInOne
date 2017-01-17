package ua.shield.hw28122016.task;

import ua.shield.hw28122016.annotation.DefAnnotation;

import java.util.Scanner;

/**
 * Created by sa on 30.12.16.
 */
@DefAnnotation(desc = "Оператор выбора")
public class ChooseOperation {
       Scanner scanner = new Scanner(System.in);

    @DefAnnotation(desc = "Составить программу, которая в зависимости от порядкового номера дня\n" +
            "недели (1,2,..., 7) выводит на экран его название(понедельник, \n" +
            "вторник, ..., воскресенье")
    public void firstTask() {
        String choosedDayIndex = null;
        System.out.println("Введите порядковый номер для недели:");
        int dayOfWeek = scanner.nextInt();

        switch (dayOfWeek) {
            case 1:
                choosedDayIndex = "Понедельник";
                break;
            case 2:
                choosedDayIndex = "Вторник";
                break;
            case 3:
                choosedDayIndex = "Среда";
                break;
            case 4:
                choosedDayIndex = "Четверг";
                break;
            case 5:
                choosedDayIndex = "Пятница";
                break;
            case 6:
                choosedDayIndex = "Суббота";
                break;
            case 7:
                choosedDayIndex = "Воскресение";
                break;

        }
        System.out.println(choosedDayIndex != null ? choosedDayIndex : "Нет такого дня недели");
    }

    @DefAnnotation(desc = "Составить программу, которая в зависимости от порядкового номера месяца\n" +
            " (1,2,..., 12) выводит на экран его название(январь, февраль,..., декабрь")
    public void secondTask() {
         final String [] monthArr=new String[]{
                "Январь","Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
                "Август", "Сентябрь","Октябрь","Ноябрь","Декабрь"
        };
        System.out.println("Введите порядковый номер месяца:");
        int monthIndex = scanner.nextInt();
        if(monthIndex>=1 && monthIndex<=12){
            System.out.println(monthArr[monthIndex-1]);
        }else{
            System.out.println("Месяца с таким номером не существует");
        }
    }
}
