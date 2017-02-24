package ua.shield.test;

/**
 * Created by sa on 24.02.17.
 */
public class CarBarier implements Runnable {
    int number;
    private final  MyCyclicBarrier CYCLICBARRIER;
    public CarBarier(int i,MyCyclicBarrier cyclicBarrier) {
        CYCLICBARRIER=cyclicBarrier;
        number=i;
    }

    @Override
    public void run() {
        System.out.printf("Автомобиль %d подъехал к барьеру",number);
        CYCLICBARRIER.await();
        System.out.printf("Автомобиль %d продолжил движение",number);
    }
}
