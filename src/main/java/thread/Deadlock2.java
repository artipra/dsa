package thread;

public class Deadlock2 {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 66;

        Thread t1 = new Thread(new Thread1(i1,i2));
        Thread t2 = new Thread(new Thread2(i1,i2));
        t1.start();t2.start();
    }
}
class Thread1 implements Runnable{
    Integer i1 = null;
    Integer i2 = null;
    Thread1(Integer i1, Integer i2){
        this.i1 = i1;
        this.i2 = i2;
    }
    @Override
    public void run() {
        synchronized (i1){
            System.out.println("acquired the lock " + i1 +" object "+ Thread.currentThread());
            synchronized(i2){
                System.out.println("acquired the lock " + i2 +" object "+ Thread.currentThread());
            }
        }
    }
}
class Thread2 implements Runnable{
    Integer i1 = null;
    Integer i2 = null;
    Thread2(Integer i1, Integer i2){
        this.i1 = i1;
        this.i2 = i2;
    }
    @Override
    public void run() {
        synchronized (i2){
            System.out.println("acquired the lock " + i2 +" object "+ Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(i1){
                System.out.println("acquired the lock " + i1 +" object "+ Thread.currentThread());
            }
        }
    }
}