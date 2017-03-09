package ua.shield.test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import java.util.List;

/**
 * Created by sa on 07.03.17.
 */
public class SimpleMock {
    public static void main(String[] args) {
        List<String> list= Mockito.mock(List.class);
        when(list.get(-1)).thenReturn("A");
        System.out.println(list.add("a"));
        System.out.println(list.get(-1));
        System.out.println(list.size());

    }
}
