package ua.shield.hw29012017;

import java.util.*;

/**
 * Created by sa on 31.01.17.
 */
public class Main {
    public static void main(String[] args) {

        String[] arr={"one","two","three","abc"};
       printArray(sortArray(arr));

    }


    private static String getString() {
        String result = "";
        String tmpString;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            tmpString = scanner.nextLine();
            if (tmpString.trim().equals("")) {
                break;
            }
            result += tmpString;
        }
        return result;
    }

    private static String firstHalf(String str){
        return str.substring(0,str.length()/2);
    }

    private static boolean isEndWithSub(String str,String end){
        return str.endsWith(end);
    }


    /**
     * Сортировка массива типа T
     * @param arr -входящий массив
     * @return -отсортированный массив
     */
    private static<T> T [] sortArray(T[] arr){
        List<T> ts = Arrays.asList(arr);
        ts.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return (T[]) ts.toArray();
    }


    /**
     * Сортировка массива типа String
     * @param arr -входящий массив
     * @return -отсортированный массив
     */
    private static String [] sortStringArray(String[] arr){
        String tmpString;
        Integer minIndex;
        for (int i=0;i<arr.length;i++){
            minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j].compareTo(arr[i])<0){
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                tmpString=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=tmpString;
            }
        }
        return arr;
    }

    /**
     * Печать массива
     * @param array -входящий массив
     * @param <T>
     */
    private static<T> void printArray(T [] array){
        Arrays.stream(array).forEach(e-> System.out.println(e));
    }

}
