package exception;


import java.io.IOException;

public class WithoutExceptionDemo {

    void set(){

        try{
            System.out.println(11/0);
        }catch(ArithmeticException e){
            throw new NullPointerException("nullpointer ex");
        }

    }
    public static void main(String[] args) {
        try{
            System.out.println("helllo");
        }
        catch(RuntimeException e){

        }
    }
}
