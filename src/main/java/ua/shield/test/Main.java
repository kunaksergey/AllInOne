package ua.shield.test;

/**
 * Created by sa on 31.01.17.
 */
public class Main {
    final private static int val = 5;

    public static void main(String args[]) {
        MyClock myClock1 = new MyClock("Тик");
        MyClock myClock2 = new MyClock("Так");
        myClock1.start();
        myClock2.start();
        try {
            myClock1.join();
            myClock2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class MyClock implements Runnable {
        String name;
        Thread thread;

        public MyClock(String name) {
            this.name = name;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            synchronized (Main.class) {
                for (int i = 0; i < val; i++) {
                    Main.class.notifyAll();
                    System.out.println(name);
                    try {
                        if (i < val - 1) {
                            Main.class.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

        public void start() {
            new Thread(this).start();
        }

        public void join() throws InterruptedException {
            thread.join();
        }
    }
}


