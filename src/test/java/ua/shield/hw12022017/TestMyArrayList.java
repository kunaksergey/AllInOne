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
    public void testAddAll(){
        List<String> innerList=new MyArrayList<>(list);
        String [] strList={"One","Two",null,"Four"};
        List<String> arrayList=new ArrayList<>(Arrays.asList(strList));
        innerList.addAll(3,arrayList);
        Assert.assertEquals(18,innerList.size());
    }

    @Test
    public void testAddAllIndex(){
        List<String> innerList=new MyArrayList<>(list);
        String [] strList={"One","Two",null,"Four"};
        List<String> arrayList=new ArrayList<>(Arrays.asList(strList));
        Assert.assertEquals(14,innerList.size());
        innerList.addAll(3,arrayList);
        Assert.assertEquals(18,innerList.size());
    }

    @After
    public void printList(){
        System.out.println(list);
    }
}
