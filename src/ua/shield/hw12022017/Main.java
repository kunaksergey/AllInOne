package ua.shield.hw12022017;

import java.util.List;

/**
 * Created by sa on 12.02.17.
 */
public class Main {
    public static void main(String[] args) {
        List<String> myList=new MyArrayList<>();
        List<String> myList2=new MyArrayList<>();
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");

        myList2.add("2 One");
        myList2.add("2 Two");
        myList2.add("2 Three");
        myList.addAll(myList2);
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println(myList.indexOf("One"));
        System.out.println(myList.contains("Five2"));
    }
}
