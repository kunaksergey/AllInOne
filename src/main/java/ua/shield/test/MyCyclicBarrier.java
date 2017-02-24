package ua.shield.test;

/**
 * Created by sa on 24.02.17.
 */
public class MyCyclicBarrier {
    Runnable action;

    public MyCyclicBarrier(Runnable action) {
        this.action = action;
    }

    public void await() {
    }
}
