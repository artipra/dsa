package string;

import java.util.Arrays;

public class LongestPailndromic {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("bb"));
//        System.out.println(solve1("bobabtbobl"));
        System.out.println(solve3("aeiOUz"));
    }

    public static String solve3(String A) {
        StringBuilder sb = new StringBuilder(A);
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(Character.isUpperCase(c)){
                sb.deleteCharAt(i); i = i-1;
            }
            if("aeiou".indexOf(c) != -1)sb.setCharAt(i,'#');
        }

        return sb.append(sb).toString();
    }

    public static int solve2(String A, int B){
        if(B == 0) return A.length();
        char[] arr = new char[26];
        for(int i = 0; i<A.length(); i++){
            arr[(A.charAt(i)-'a')]++;
        }
        Arrays.sort(arr);
      //  for(char c : arr) System.out.print((int)c);

        int i=0,min=0,count=0;
        for(; i<26; i++){
            if(arr[i] != 0){
                min +=  arr[i];
                count++;
                if(min == B)break;
            }
        }
        return (A.length()-1-count);
    }
    public static int solve1(String A) {
        int x =0;
        for(int i=0;i<=A.length()-3; i++){
            System.out.println(A.substring(i,i+3));
            if(A.substring(i,i+3).equals("bob")) x++;
        }
        return x;
    }
    public static String longestPalindrome(String A) {
        if (A.length() == 1) return A;
        if(A.length() == 2){
            if(A.charAt(0) == A.charAt(1)) return A;
            return String.valueOf(A.charAt(0));
        }
        int max = 0;
        String ans = "";      //6:38
        for (int i = 1; i < A.length() - 1; i++) {
            int l = i - 1;
            int r = i + 1;
            if (A.charAt(l) == A.charAt(i)) l--;
            if (A.charAt(r) == A.charAt(i)) r++;
            while (l >= 0 && r < A.length()) {
                if (A.charAt(l) != A.charAt(r)) break;
                l--;
                r++;
            }

            if (max < (r - l - 1)) {
                max = r - l - 1;
                ans = A.substring(l + 1, r);
            }

        }
        return ans;
    }

}