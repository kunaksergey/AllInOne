package ua.shield.hw12022017;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sa on 12.02.17.
 */
public class Main {
    public static void main(String[] args) {
        String[] arrStr = {null, "xx", "our"};

        List<String> myArrayList = new MyArrayList<>(Arrays.asList(arrStr));
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());
        Iterator<String> iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());

    }
}
