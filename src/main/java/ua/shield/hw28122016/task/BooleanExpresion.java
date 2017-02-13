package ua.shield.hw28122016.task;

import ua.shield.hw28122016.annotation.DefAnnotation;

/**
 * Created by sa on 29.12.16.
 */
@DefAnnotation(desc = "Логические выражения")
public class BooleanExpresion {

    @DefAnnotation(desc = "Вычислить значение логического выражениея при слудующих значениях" +
            "логических величин A,B и C A=истина,B=ложь, C=ложь")
    public void taskOne() {
        final boolean a = true;
        final boolean b = false;
        final boolean c = false;
        System.out.println("A или B:" + (a || b));
        System.out.println("A и B:" + (a && b));
        System.out.println("B или C:" + (b || c));

    }

    @DefAnnotation(desc = "Вычислить значение логического выражениея при слудующих значениях" +
            "логических величин X,Y и Z:X=Ложь, Y=истина,Z=ложь")
    public void taskTwo() {
        final boolean x = false;
        final boolean y = true;
        final boolean z = false;
        System.out.println("X или Z" + (x || z));
        System.out.println("X и Y" + (x && y));
        System.out.println("X и Z" + (x && z));

    }

    @DefAnnotation(desc = "Вычислить значение логического выражениея при слудующих значениях" +
            "логических величин A,B и C A=истина,B=ложь, C=ложь")
    public void taskThree() {
        final boolean a = true;
        final boolean b = false;
        final boolean c = false;
        System.out.println("не A и B:" + (!a && b));
        System.out.println("A или не B:" + (a || !b));
        System.out.println("A и B или С:" + ((a && b) || c));
    }

    @DefAnnotation(desc = "Вычислить значение логического выражения при следующих значениях логи-\n" +
            "ческих величин X, Y и Z: X = Истина, Y = Истина, Z = Ложь:\n" +
            "а) не X и Y; б) X или не Y; в) X или Y и Z.")
    public void taskFour() {
        final boolean x = true;
        final boolean y = true;
        final boolean z = false;
        System.out.println("а) не X и Y:" + (!x & y));
        System.out.println("б) X или не Y:" + (x || !y));
        System.out.println("а) в) X или Y и Z:" + (x || y && z));
    }

    @DefAnnotation(desc = "Записать логические выражения, которые имеют значение \"Истина\"\n" +
            "только при выполнении указанных условий:\n" +
            "а) х > 2 и у > 3; е) неверно, что х > 2;\n" +
            "б) х > 1 или y> 2; ж) неверно, что х > 0 и х < 5;\n" +
            "в) х > 0 и у < 5; з) 10 < x< 20;\n" +
            "г) х > 3 или x < 1; и) 0 < y 4 и x < 5.\n" +
            "д) х > 3 и x < 10;")
    public void taskFive() {
        System.out.println("а) х > 2 и у > 3:(x>2&&y>3)");
        System.out.println("б) х > 1 или y > 2:(x>1||y>2)");
        System.out.println("в) х > 0 и у < 5:(x>0&&y<5)");
        System.out.println("г) х > 3 или x < 1:(x>3||x<1)");
        System.out.println("д) х > 3 и x < 10:(x>3&&x<10)");
        System.out.println("неверно, что х > 2:!(x>2)");
        System.out.println("ж) неверно, что х > 0 и х < 5:!(x>0&&x<5)");
        System.out.println("з) 10 < x< 20:(x>10&&x<20)");
        System.out.println("и) 0 < y< 4 и x < 5:(y>0&&y<4&&x<5)");

    }

    @DefAnnotation(desc = "Записать условие, которое является истинным, когда:\n" +
            "а) каждое из чисел А и В больше 100;\n" +
            "б) только одно из чисел А и В четное;\n" +
            "в) хотя бы одно из чисел А и В положительно;\n" +
            "г) каждое из чисел А, В, С кратно трем;\n" +
            "д) только одно из чисел А, В и С меньше 50;\n" +
            "е) хотя бы одно из чисел А, В, С отрицательно;")
    public void taskSix() {
        System.out.println("а) каждое из чисел А и В больше 100 :(a>100&&b>100)");
        System.out.println("б) только одно из чисел А и В четное: (a%2==0&b%2!=0)||(a%2!=0&b%2==0)");
        System.out.println("в) хотя бы одно из чисел А и В положительно:(a>0||b>0)");
        System.out.println("г) каждое из чисел А, В, С кратно трем:(a%3==0&&b%3==0&&c%3==0)");
        System.out.println("д) только одно из чисел А, В и С меньше 50: (a<50&&b>=50&&c>=50)||" +
                "(b<50&&a>=50&&c>=50)||(c<50&&b>=50&&a>=50)");
        System.out.println("хотя бы одно из чисел А, В, С отрицательно: (a<0||b<0||c<0)");

    }


    @DefAnnotation(desc = "Записать условие, которое является истинным, когда:\n" +
            "а) каждое из чисел X и Y нечетное;\n" +
            "б) только одно из чисел X и Y меньше 20;\n" +
            "в) хотя бы одно из чисел X и Y равно нулю;\n" +
            "г) каждое из чисел X, Y, Z отрицательное;\n" +
            "д) только одно из чисел X, Y и Z кратно пяти;\n" +
            "е) хотя бы одно из чисел X, Y, Z больше 100.")
    public void taskSeven() {
        System.out.println("а) каждое из чисел X и Y нечетное: (x%2!=0&&y%2!=0)");
        System.out.println("б) только одно из чисел X и Y меньше 20:(x<20&&y>=20)||(y<20&&x>=20)");
        System.out.println("в) хотя бы одно из чисел X и Y равно нулю:(x==0||y==0)");
        System.out.println("г) каждое из чисел X, Y, Z отрицательное: (x<0&&y<0&&z<0)");
        System.out.println("д) только одно из чисел X, Y и Z кратно пяти:(x%5==0&&y%5!=0&&z%5!=0)||" +
                "(y%5==0&&x%5!=0&&z%5!=0)||(z%5==0&&x%5!=0&&y%5!=0)");
        System.out.println("е) хотя бы одно из чисел X, Y, Z больше 100:(x>100||y>100||z>100)");
    }
}
