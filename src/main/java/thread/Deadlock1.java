package thread;

// deadlock before java 8 anonymous
public class Deadlock1 {
   public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 66;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized (i1){
                    System.out.println("acquired the lock " + i1 +" object "+ Thread.currentThread());
                    synchronized(i2){
                        System.out.println("acquired the lock " + i2 +" object "+ Thread.currentThread());
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (i2){
                    System.out.println("acquired the lock " + i2 +" object "+ Thread.currentThread());
                    synchronized(i1){
                        System.out.println("acquired the lock " + i1 +" object "+ Thread.currentThread());
                    }
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();t2.start();
    }
}