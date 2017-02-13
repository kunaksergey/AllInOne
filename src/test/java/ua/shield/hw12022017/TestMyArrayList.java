package ua.shield.hw12022017;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sa on 13.02.17.
 */
public class TestMyArrayList {
    static List<String> list = new MyArrayList<>();
    static List<TestClass> listTestClass = new MyArrayList<>();

    @BeforeClass
    public static void fillListTestClass() {
        listTestClass.add(new TestClass(1));
        listTestClass.add(new TestClass(2));
        listTestClass.add(new TestClass(3));
        listTestClass.add(new TestClass(4));
        listTestClass.add(new TestClass(5));
        listTestClass.add(new TestClass(6));
        listTestClass.add(new TestClass(7));
        listTestClass.add(new TestClass(8));
    }

    @BeforeClass
    public static void fillList() {
        list.add("One");
        list.add("Two");
        list.add(null);
        list.add("Four");
        list.add("Three");
        list.add("Four");
        list.add("Four");
        list.add("Five");
        list.add(null);
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(14, list.size());
        Assert.assertEquals(8, listTestClass.size());
    }

    @Test
    public void testToArray() {
        Assert.assertEquals(14, list.toArray().length);
        Assert.assertEquals(8, listTestClass.toArray().length);
    }

    @Test
    public void testAddAllIndex() {
        List<String> innerList = new MyArrayList<>(list);
        String[] strList = {"One", "Two", null, "Four"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(strList));
        innerList.addAll(3, arrayList);
        Assert.assertEquals(18, innerList.size());
    }

    @Test
    public void testAddAll() {
        List<String> innerList = new MyArrayList<>(list);
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);

        String[] strArray = {"One", "Two", null, "Four"};
        TestClass[] testClassArray = {new TestClass(9), new TestClass(10), null, new TestClass(12)};

        List<String> strList = new ArrayList<>(Arrays.asList(strArray));
        List<TestClass> testClassList = new ArrayList<>(Arrays.asList(testClassArray));

        innerList.addAll(strList);
        Assert.assertEquals(18, innerList.size());
        innerListTestClass.addAll(testClassList);
        Assert.assertEquals(12, innerListTestClass.size());
    }

    @Test
    public void testIndexOfEl() {
        List<String> innerList = new MyArrayList<>(list);
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);
        Assert.assertEquals(2, innerList.indexOf(null));
        Assert.assertEquals(3, innerList.indexOf("Four"));
        Assert.assertEquals(-1, innerList.indexOf("XXX"));
        Assert.assertEquals(13, innerList.indexOf("Ten"));
        Assert.assertEquals(13, innerList.indexOf("Ten"));
        Assert.assertEquals(7, innerListTestClass.indexOf(new TestClass(8)));
        Assert.assertEquals(-1, innerListTestClass.indexOf(new TestClass(11)));
    }

    @Test
    public void testIndexLastOfEl() {
        List<String> innerList = new MyArrayList<>(list);
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);
        Assert.assertEquals(8, innerList.lastIndexOf(null));
        Assert.assertEquals(6, innerList.lastIndexOf("Four"));
        Assert.assertEquals(-1, innerList.lastIndexOf("XXX"));
        Assert.assertEquals(13, innerList.lastIndexOf("Ten"));
        Assert.assertEquals(7, innerListTestClass.indexOf(new TestClass(8)));
        innerListTestClass.add(new TestClass(8));
        Assert.assertEquals(8, innerListTestClass.lastIndexOf(new TestClass(8)));
    }

    @Test
    public void testCapacity() {
        List<String> innerList = new MyArrayList<>(20);
        innerList.addAll(list);
        Assert.assertEquals(14, innerList.size());
    }

    @Test
    public void testRemoteObject() {
        List<String> innerList = new MyArrayList<>();
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);

        innerList.addAll(list);
        innerList.remove(null);
        Assert.assertEquals(13, innerList.size());
        innerList.remove("Four");
        Assert.assertEquals(12, innerList.size());
        innerList.remove("XXX");
        Assert.assertEquals(12, innerList.size());

        innerListTestClass.add(new TestClass(8));
        innerListTestClass.add(new TestClass(9));
        innerListTestClass.remove(new TestClass(8));
        Assert.assertEquals(9, innerListTestClass.size());
        innerListTestClass.remove(null);
        Assert.assertEquals(9, innerListTestClass.size());
    }

    @Test
    public void testRemoteAll() {
        List<String> innerList = new MyArrayList<>();
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);
        List<String> listForRemove = new ArrayList<>(list);
        List<TestClass> listTestClassForRemove = new ArrayList<>(listTestClass);
        innerList.addAll(list);
        innerListTestClass.addAll(listTestClass);
        innerList.removeAll(listForRemove);
        innerList.removeAll(listForRemove);
        innerListTestClass.removeAll(listTestClassForRemove);
        innerListTestClass.removeAll(listTestClassForRemove);
        Assert.assertEquals(0, innerList.size());
        Assert.assertEquals(0, innerListTestClass.size());
    }

    @Test
    public void isEmpty() {
        List<String> innerList = new MyArrayList<>();
        Assert.assertTrue(innerList.isEmpty());
    }

    @After
    public void printList() {
        System.out.println(list);
        System.out.println(listTestClass);
    }
}
