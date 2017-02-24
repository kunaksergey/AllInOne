package ua.shield.test;

/**
 * Created by sa on 24.02.17.
 */
public class MyCyclicBarrier {
    Runnable action;
    private final int COUNTTHREAD;
    private int count;

    public MyCyclicBarrier(int countThread,Runnable action) {
        this.action = action;
        COUNTTHREAD=countThread;
    }

    public synchronized void await() throws InterruptedException {
        count++;
        if(count<COUNTTHREAD) {
          this.wait();
        }
        if(count==COUNTTHREAD) {
            action.run();
            count = 0;
            this.notifyAll();
        }
        }
    }


