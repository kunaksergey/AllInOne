package ua.shield.test;

/**
 * Created by sa on 24.02.17.
 */
public class FerryBoat implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Паром переправил автомобили");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
