package ua.shield.test;

/**
 * Created by sa on 24.02.17.
 */
public class TestBarier {
    public static void main(String[] args) throws InterruptedException {
        MyCyclicBarrier cyclicBarrier=new MyCyclicBarrier(new FerryBoat());
        for (int i = 0; i <9 ; i++) {
            new Thread(new CarBarier(i,cyclicBarrier)).start();
            Thread.sleep(400);
        }
    }
}
