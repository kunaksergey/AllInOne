package ua.shield;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.lang.StrictMath.abs;

/**
 * Created by sa on 07.03.17.
 */
@RunWith(Parameterized.class)
public class AbsTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> getIterator(){
        Object[][] listObj=new Object[][]{{-1,1},{-2,2},{-3,3},{0,0},{1,1}};
        return Arrays.asList(listObj);
    }


    @Parameterized.Parameter(0)
    public static int argOne;
    @Parameterized.Parameter(1)
    public static int argTwo;
    @Test
    public void test_abs(){
        Assert.assertEquals(abs(argOne),argTwo);
    }
}
