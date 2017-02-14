package ua.shield.hw12022017;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sa on 12.02.17.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<TestClass> listTestClass=new MyArrayList<>();
        listTestClass.add(new TestClass(1));
        listTestClass.add(new TestClass(2));
        listTestClass.add(new TestClass(3));
        listTestClass.add(new TestClass(4));
        listTestClass.add(new TestClass(5));
        listTestClass.add(new TestClass(6));
        listTestClass.add(new TestClass(7));
        listTestClass.add(new TestClass(8));
        listTestClass.add(null);
        listTestClass.add(new TestClass(9));
        listTestClass.add(null);
       // System.out.println(listTestClass.indexOf(new TestClass(8)));
        Iterator <TestClass> iterator=listTestClass.iterator();
        TestClass testClass;
        while (iterator.hasNext()){
            testClass=iterator.next();
            if(testClass==null) iterator.remove();
        }
        System.out.println(listTestClass);
        System.out.println(listTestClass.size());
        listTestClass.set(2,new TestClass(5));
        System.out.println(listTestClass);
        MyArrayList<TestClass> listTestClass2=new MyArrayList<>();
        listTestClass2.add(new TestClass(5));
        listTestClass2.add(new TestClass(6));
        listTestClass2.add(new TestClass(7));
        listTestClass.addAll(3,listTestClass2);
        System.out.println(listTestClass);
    }
}
