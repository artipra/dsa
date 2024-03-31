package string;

import java.time.Clock;

public class StringIntern {

    public static void main(String[] args) {
        String a = new String("hello");
        System.out.println(a.hashCode());
        a = a.intern();
        String b = a;
        System.out.println(a.hashCode());

        System.out.println(b.hashCode());

        String atr [] = new String[100000000*100000000];
    }
}
