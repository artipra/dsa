package thread;

public class Case7 extends Thread{

    public void start(){
        super.start();
        System.out.println(Thread.currentThread()+"  start method");
    }

    public void run(){
        System.out.println(Thread.currentThread()+"  run method new thread-----");
    }
    public static void main(String[] args) {

        Case7 t1 = new Case7();
        t1.start();
        System.out.println(Thread.currentThread()+" main method-----");
    }
}
