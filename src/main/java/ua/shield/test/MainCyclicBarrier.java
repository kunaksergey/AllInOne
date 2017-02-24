package ua.shield.test;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by sa on 24.02.17.
 */
public class MainCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        MyCyclicBarrier cyclicBarrier=new MyCyclicBarrier(3,new FerryBoat());
        CyclicBarrier cb=new CyclicBarrier(3,new FerryBoat());
        for (int i = 0; i <9 ; i++) {
            new Thread(new CarBarier(i,cyclicBarrier,cb)).start();
            Thread.sleep(400);
        }
    }
}
