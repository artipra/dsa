package string;

import java.util.ArrayList;

public class ImmutableClassDemo {

    public static void main(String[] args) {
        ImmutableClass demo = new ImmutableClass("ABC",null);
        System.out.println(demo);
        String name = demo.getName();
        ArrayList<Integer> list = demo.getList();
        list.add(11);list.add(133);
        System.out.println(demo);

    }
}
