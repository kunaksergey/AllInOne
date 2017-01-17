package ua.shield.hw04012017;

import java.util.Scanner;

/**
 * Created by sa on 17.01.17.
 */
public class Main {
    private static   Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        spruce();
        repeatedDigit();
    }
    public static void spruce() {
        String str="*";
        String result="";
        System.out.println("Введите размер дерева");

        int size = scanner.nextInt();
        for(int i=1;i<=size;i++,str=str+"**"){
            result=result.replaceAll(" \\*","  *")+" "+str+"\n";
        }
        System.out.println(result);
    }


    public static void repeatedDigit() {
        StringBuilder stringBuilder=new StringBuilder();
        int[]digitArr=new int[10];
        System.out.println("Введите число");
        int val = scanner.nextInt();
        while (val!=0){
            digitArr[val-val/10*10]++;
            val=val/10;
        }
        stringBuilder.append("Повторяющиеся числа:\n");
        for (int i=0;i<=9;i++){
            if(digitArr[i]!=0){
                stringBuilder.append(i).append("-").append(digitArr[i]).append("раз(а)\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
