package ua.shield.test;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by sa on 24.02.17.
 */
public class CarBarier implements Runnable {
    int number;
    private final  MyCyclicBarrier CYCLICBARRIER;
    private final  CyclicBarrier CB;
    public CarBarier(int i, MyCyclicBarrier cyclicBarrier, CyclicBarrier cb) {
        CYCLICBARRIER=cyclicBarrier;
        number=i;
        CB=cb;
    }

    @Override
    public void run() {
        System.out.printf("Автомобиль %d подъехал к барьеру\n",number);
        try {
            CYCLICBARRIER.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Автомобиль %d продолжил движение\n",number);
    }
}
