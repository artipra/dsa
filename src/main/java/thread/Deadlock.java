package thread;
public class Deadlock {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 66;
        // java 8 implementation
        Runnable r1 = () -> {
                synchronized (i1){
                    System.out.println("acquired the lock " + i1 +" object "+ Thread.currentThread());
                    synchronized(i2){
                        System.out.println("acquired the lock " + i2 +" object "+ Thread.currentThread());
                    }
                }
            };

        Runnable r2 = () -> {
                synchronized (i2){
                    System.out.println("acquired the lock " + i2 +" object "+ Thread.currentThread());
                    synchronized(i1){
                        System.out.println("acquired the lock " + i1 +" object "+ Thread.currentThread());
                    }
                }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();t2.start();
    }
}

