package ua.shield;

import org.junit.*;

/**
 * Created by sa on 06.03.17.
 */

public class LifeCicleExample {

    public LifeCicleExample() {
        System.out.println("Constructor()");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass()");
    }
    @Before
    public void before(){
        System.out.println("before");
    }
    @Test
    public void test0(){
        System.out.println("Test 0");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @After
    public void after(){
        System.out.println("after");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass()");
    }
}
