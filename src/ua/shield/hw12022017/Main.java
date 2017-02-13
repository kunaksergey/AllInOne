package ua.shield.hw12022017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sa on 12.02.17.
 */
public class Main {
    public static void main(String[] args) {
    List<String> myList= getFilledArrayList(new MyArrayList<>());
    List<String> arrayList=getFilledArrayList(new ArrayList<>());
    //testAdd(myList,arrayList);
   // testAddIndex(myList,arrayList);
    //testIndexOf(myList,arrayList);
    //testLastIndexOff(myList,arrayList);
     testAddAllIndex(myList,arrayList);
        /*System.out.println(myList);
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
        System.out.println("testAddIndex");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        myList.add(15,"One+half");
        arrayList.add(15,"One+half");
        System.out.println("*********after*********");
        System.out.println(myList);
        System.out.println(arrayList);
    }

    private static void testAddAll(List<String> myList, List<String> arrayList) {
        System.out.println("testAddIndex");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        String [] arrayForAddExample={"X","Y","X"};
        myList.addAll(new ArrayList<String>(Arrays.asList(arrayForAddExample)));
        arrayList.addAll(new ArrayList<String>(Arrays.asList(arrayForAddExample)));
        System.out.println("*********after*********");
        System.out.println(myList);
        System.out.println(arrayList);
    }

    private static void testAddAllIndex(List<String> myList, List<String> arrayList) {
        System.out.println("testAddAllIndex");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        String [] arrayForAddExample={"X","Y","X"};
        myList.addAll(3,new ArrayList<String>(Arrays.asList(arrayForAddExample)));
        arrayList.addAll(3,new ArrayList<String>(Arrays.asList(arrayForAddExample)));
        System.out.println("*********after*********");
        System.out.println(myList);
        System.out.println(arrayList);
    }

    private static void testIndexOf(List<String> myList, List<String> arrayList) {
        System.out.println("testIndexOf");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        System.out.println("My array: indexOf="+myList.indexOf("Four"));
        System.out.println("ArrayList: indexOf="+arrayList.indexOf("Four"));

    }
    private static void testLastIndexOff(List<String> myList, List<String> arrayList) {
        System.out.println("testLastIndexOff");
        System.out.println("*********before*********");
        System.out.println(myList);
        System.out.println(arrayList);
        System.out.println("My array: lastIndexOf="+myList.lastIndexOf("Four"));
        System.out.println("ArrayList: lastIndexOf="+arrayList.lastIndexOf("Four"));

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
