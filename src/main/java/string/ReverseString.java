package string;

import java.util.ArrayList;

public class ReverseString {

    public static void main(String [] args){
       ArrayList<Character> s = new ArrayList<>();
       s.add('S');s.add('c');s.add('a');s.add('l');s.add('e');
       s.add('r');s.add('A');s.add('c');s.add('a');s.add('d');
       s.add('e');s.add('m');s.add('y');s.add('2');s.add('0');
       s.add('2');s.add('0');s.add('%');
        System.out.println(solve(s));
    }

    public static int solve(ArrayList<Character> A) {
        for(int i=0; i<A.size(); i++){
            if((48 <= A.get(i) && A.get(i) <= 57) ||
                    (65 <= A.get(i) && A.get(i) <= 90) ||
                     (97 <= A.get(i) && A.get(i) <= 122)) continue;
            return 0;
        }
        return 1;
    }

    static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    static String reverse1(String str){
        int m = str.length()/2;
        StringBuilder sb = new StringBuilder(str);
        for(int i=0; i<m; i++){
            char c = sb.charAt(i);
            sb.setCharAt(i,str.charAt(str.length()-1-i));
            sb.setCharAt(str.length()-1-i,c);
        }
        return sb.toString();
    }

    static String reverse2(String str){
        byte[] arr = str.getBytes();
        byte[] res = new byte[arr.length];
        for(int i=0; i<arr.length; i++){
            res[i] = arr[arr.length-1-i];
        }
        return new String(res);
    }


    static String reverse3(String str){
        byte[] arr = str.getBytes();
        byte[] res = new byte[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            res[arr.length-i-1] = arr[i];
        }
        return new String(res);
    }


}
