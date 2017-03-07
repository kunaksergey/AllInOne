package ua.shield.hw12022017;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sa on 07.03.17.
 */
public class HumcrestTest {

    @Test
    public void test_has_obj_count(){
        List<String> list= Arrays.asList("A","b","C","X","X","1","2","3");
        Assert.assertThat(list,hasObject("X",2));
    }

    private Matcher<? super List<String>> hasObject(String x, int i) {
        return new BaseMatcher<List<String>>() {
            private int count=0;
            @Override
            public boolean matches(Object item) {
                for(String str: (List<String>)item){
                    if(x.equals(str)){
                        count++;
                    }
                }
                return i==count;
            }
            @Override
            public void describeTo(Description description) {
                description.appendText(i+" of "+x+" but "+count);
            }
        };
    }
}
