package string;

public class ReverseString {

    public static void main(String [] args){
        System.out.println(reverse2("abcd"));
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


}
