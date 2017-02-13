package ua.shield.hw12022017;

/**
 * Created by sa on 13.02.17.
 */
public class TestClass {
    private int x;

    public TestClass(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
         return this.x==((TestClass)obj).getX();
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "x=" + x +
                '}';
    }
}
