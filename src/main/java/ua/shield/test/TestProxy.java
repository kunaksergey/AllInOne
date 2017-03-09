package ua.shield.test;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by sa on 07.03.17.
 */
public class TestProxy {
    public static void main(String[] args) {
        List<String> list = (List<String>) Proxy.newProxyInstance(
                null,
                new Class[]{List.class},
                (proxy, method, args1) -> {
                    switch (method.getName()) {
                        case "add":
                            return true;
                        case "get":
                            return "AAAA";
                        case "size":
                            return 5;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }
        );
        System.out.println(list.add("A"));
        System.out.println(list.get(-1));
        System.out.println(list.size());
        System.out.println(list.contains("A"));
    }
}
