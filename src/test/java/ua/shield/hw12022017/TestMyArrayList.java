package ua.shield.hw12022017;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.shield.hw12022017.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sa on 13.02.17.
 */
public class TestMyArrayList {
    static List<String> list=new MyArrayList<>();
    @BeforeClass
    public static void  fillList(){
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
    public void testAdd(){
        Assert.assertEquals(14,list.size());
    }

    @Test
    public void testToArray(){
        Assert.assertEquals(14,list.toArray().length);
    }

    @Test
    public void testAddAllIndex(){
        List<String> innerList=new MyArrayList<>(list);
        String [] strList={"One","Two",null,"Four"};
        List<String> arrayList=new ArrayList<>(Arrays.asList(strList));
        innerList.addAll(3,arrayList);
        Assert.assertEquals(18,innerList.size());
    }

    @Test
    public void testAddAll(){
        List<String> innerList=new MyArrayList<>(list);
        String [] strList={"One","Two",null,"Four"};
        List<String> arrayList=new ArrayList<>(Arrays.asList(strList));
        innerList.addAll(arrayList);
        Assert.assertEquals(18,innerList.size());
    }

    @Test
    public void testIndexOfEl(){
        List<String> innerList=new MyArrayList<>(list);
        Assert.assertEquals(2,innerList.indexOf(null));
        Assert.assertEquals(3,innerList.indexOf("Four"));
        Assert.assertEquals(-1,innerList.indexOf("XXX"));
        Assert.assertEquals(13,innerList.indexOf("Ten"));
    }

    @Test
    public void testIndexLastOfEl(){
        List<String> innerList=new MyArrayList<>(list);
        Assert.assertEquals(8,innerList.lastIndexOf(null));
        Assert.assertEquals(6,innerList.lastIndexOf("Four"));
        Assert.assertEquals(-1,innerList.lastIndexOf("XXX"));
        Assert.assertEquals(13,innerList.lastIndexOf("Ten"));
    }
    @Test
    public void testCapacity(){
        List<String> innerList=new MyArrayList<>(20);
        innerList.addAll(list);
        Assert.assertEquals(14,innerList.size());
    }

    @Test
    public void testRemoteObject(){
        List<String> innerList=new MyArrayList<>();
        innerList.addAll(list);
        innerList.remove(null);
        Assert.assertEquals(13,innerList.size());
        innerList.remove("Four");
        Assert.assertEquals(12,innerList.size());
        innerList.remove("XXX");
        Assert.assertEquals(12,innerList.size());
    }

    @Test
    public void testRemoteAll(){
        List<String> innerList=new MyArrayList<>();
        List<String> listForRemove=new ArrayList<>(list);
        innerList.addAll(list);
        innerList.removeAll(listForRemove);
        Assert.assertEquals(0,innerList.size());
    }

    @Test
    public void isEmpty(){
        List<String> innerList=new MyArrayList<>();
        Assert.assertTrue(innerList.isEmpty());
    }
    @After
    public void printList(){
        System.out.println(list);
    }
}
