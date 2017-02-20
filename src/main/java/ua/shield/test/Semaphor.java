package ua.shield.test;

/**
 * Created by sa on 20.02.17.
 */
public class Semaphor {
    private final int permit;
    private int count=0;
    public Semaphor(int permit) {
        this.permit = permit;
    }

    synchronized void start(){

        while(count+1>permit){
            try {
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;

    }

    synchronized void  stop(){
        count--;
        this.notifyAll();
    }


}
