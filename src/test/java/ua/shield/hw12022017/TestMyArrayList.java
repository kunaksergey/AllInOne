package ua.shield.hw12022017;


import org.junit.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by sa on 13.02.17.
 */
public class TestMyArrayList {
     List<String> list = new MyArrayList<>();
     List<TestClass> listTestClass = new MyArrayList<>();


    @Before
    public void fillListTestClass() {
        listTestClass.add(new TestClass(1));
        listTestClass.add(new TestClass(2));
        listTestClass.add(null);
        listTestClass.add(new TestClass(4));
        listTestClass.add(new TestClass(5));
        listTestClass.add(new TestClass(6));
        listTestClass.add(new TestClass(7));
        listTestClass.add(new TestClass(8));

    }

    @Before
    public  void fillList() {
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
        assertEquals(14, list.size());
        assertEquals(8, listTestClass.size());
    }

    @Test
    public void testToArray() {
        assertEquals(14, list.toArray().length);
        assertEquals(8, listTestClass.toArray().length);
    }

    @Test
    public void testAddAllIndex() {
        List<String> innerList = new MyArrayList<>(list);
        String[] strList = {"One", "Two", null, "Four"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(strList));
        innerList.addAll(3, arrayList);
        assertEquals(18, innerList.size());
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
        assertEquals(18, innerList.size());
        innerListTestClass.addAll(testClassList);
        assertEquals(12, innerListTestClass.size());
    }

    @Test
    public void testIndexOfEl() {
        List<String> innerList = new MyArrayList<>(list);
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);
        assertEquals(2, innerList.indexOf(null));
        assertEquals(3, innerList.indexOf("Four"));
        assertEquals(-1, innerList.indexOf("XXX"));
        assertEquals(13, innerList.indexOf("Ten"));
        assertEquals(13, innerList.indexOf("Ten"));
        assertEquals(7, innerListTestClass.indexOf(new TestClass(8)));
        assertEquals(-1, innerListTestClass.indexOf(new TestClass(11)));
    }

    @Test
    public void testIndexLastOfEl() {
        List<String> innerList = new MyArrayList<>(list);
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);
        assertEquals(8, innerList.lastIndexOf(null));
        assertEquals(6, innerList.lastIndexOf("Four"));
        assertEquals(-1, innerList.lastIndexOf("XXX"));
        assertEquals(13, innerList.lastIndexOf("Ten"));
        assertEquals(7, innerListTestClass.indexOf(new TestClass(8)));
        innerListTestClass.add(new TestClass(8));
        assertEquals(8, innerListTestClass.lastIndexOf(new TestClass(8)));
    }

    @Test
    public void testCapacity() {
        List<String> innerList = new MyArrayList<>(20);
        innerList.addAll(list);
        assertEquals(14, innerList.size());
    }

    @Test
    public void testRemoteObject() {
        List<String> innerList = new MyArrayList<>();
        List<TestClass> innerListTestClass = new MyArrayList<>(listTestClass);

        innerList.addAll(list);
        innerList.remove(null);
        assertEquals(13, innerList.size());
        innerList.remove("Four");
        assertEquals(12, innerList.size());
        innerList.remove("XXX");
        assertEquals(12, innerList.size());

        innerListTestClass.add(new TestClass(8));
        innerListTestClass.add(new TestClass(9));
        innerListTestClass.remove(new TestClass(8));
        assertEquals(9, innerListTestClass.size());
        innerListTestClass.remove(null);
        assertEquals(8, innerListTestClass.size());
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
        assertEquals(0, innerList.size());
        assertEquals(0, innerListTestClass.size());
    }

    @Test
    public void isEmpty() {
        List<String> innerList = new MyArrayList<>();
        assertTrue(innerList.isEmpty());
    }
    @Test
    public void test_after_add_one(){
        List<Integer> listInteger=new MyArrayList<>();
        listInteger.add(1);
        if(listInteger.size()!=1){
            throw new AssertionError();
        }
    }
    @Test
    public void test_add_and_get(){
        List<String> listString=new MyArrayList<>();
        listString.add("A");
        assertTrue(listString.get(0).equals("A"));
      }

    @Test
    public void test_add_null(){
        List<String> listString=new MyArrayList<>();
        listString.add(null);
        assertThat(listString.size(), is(1));
    }

    @Test
    public void test_remove_ok(){
        List<String> listString=new MyArrayList<>();
        listString.add("A");
        listString.remove("A");
        if(listString.size()!=0){
            throw new AssertionError();
        }
    }

    @Test
    public void test_remove_non(){
        List<String> listString=new MyArrayList<>();
        listString.add("A") ;
        listString.remove("B");
        if(listString.size()!=1){
            throw new AssertionError();

        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_get_elem_without_add(){
        List list=new MyArrayList<>();
        list.get(0);
    }

    @After
    public void printList() {
        System.out.println(list);
        System.out.println(listTestClass);
    }

}
