package ua.shield.hw12022017;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 12.02.17.
 */
public class Main {
    public static void main(String[] args) {
    List<String> myList= getFilledArrayList(new MyArrayList<>());
    List<String> arrayList=getFilledArrayList(new ArrayList<>());
    testAdd(myList,arrayList);
    testAddIndex(myList,arrayList);
    testIndexOf(myList,arrayList);
    /*testLastIndexOff(myList,arrayList);
        System.out.println(myList);
        System.out.println(arrayList);
        myList.add("Six");
        arrayList.add("Six");
        System.out.println(myList);
        System.out.println(arrayList);
        myList.add(1,"One + half");
        arrayList.add(1,"One + half");
        System.out.println(myList);
        System.out.println(arrayList);
        */
    }

    private static void testAdd(List<String> myList, List<String> arrayList) {
        System.out.println("test-Add");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        myList.add("Seven");
        arrayList.add("Seven");
        System.out.println("*********after*********");
        System.out.println(myList);
        System.out.println(arrayList);
    }

    private static void testAddIndex(List<String> myList, List<String> arrayList) {
        System.out.println("test-Add");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        myList.add(1,"One+half");
        arrayList.add(1,"One+half");
        System.out.println("*********after*********");
        System.out.println(myList);
        System.out.println(arrayList);
    }

    private static void testIndexOf(List<String> myList, List<String> arrayList) {
        System.out.println("test-Add");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        System.out.println("My array: indexOf="+myList.indexOf("Four"));
        System.out.println("ArrayList: indexOf="+arrayList.indexOf("Four"));

    }
/*************************************************************************************/
    static List<String> getFilledArrayList(List<String> list){
         list.add("One");
         list.add("Two");
         list.add("Four");
         list.add("Three");
         list.add("Four");
         list.add("Four");
         list.add("Five");
         return list;
     }


}
