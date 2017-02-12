package ua.shield.hw12022017;

import java.util.List;

/**
 * Created by sa on 12.02.17.
 */
public class Main {
    public static void main(String[] args) {
        List<String> myList=new MyArrayList<>();
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");
        System.out.println(myList);
        System.out.println(myList.size());
    }
}
