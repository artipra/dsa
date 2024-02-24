package string;

public class RemoveSpecifiedChar {

    public static void main(String[] args) {
        String str ="abcbfgsa";
        int idx = str.indexOf('a');
        str = str.substring(0,idx)+str.substring(idx+1);
        System.out.println(str);
    }
}
