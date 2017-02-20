package ua.shield.test;

/**
 * Created by sa on 20.02.17.
 */
public class Car implements Runnable{
    Semaphor semaphor;
    private final int number;

    public Car(Semaphor semaphor,int number) {
        this.semaphor = semaphor;
        this.number=number;
    }

    @Override
    public void run() {

       semaphor.start();
        for (int i=0;i<3;i++) {
            System.out.println("Тут что-то делаем: "+number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        semaphor.stop();

    }
}
