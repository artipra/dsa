package string;
import java.util.*;
public class Anagram{

    public static void main(String[] args) {
    System.out.println(isAnagram2("spot","post"));
    }

    static boolean isAnagram2(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1,c2);
    }
    static boolean isAnagram1(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char [] arr = new char[256];

        for(int i=0; i<s1.length(); i++){
            arr[s1.charAt(i)]++;
        }


        for(int i=0; i<s2.length(); i++){
            arr[s2.charAt(i)]--;
        }

        for(int i= 0; i<256; i++){
            if(arr[i] != 0) {return false;}
        }
        return true;
    }

    static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        HashMap<Character,Integer> hm = new HashMap();
        for(int i=0; i<s1.length(); i++){
            hm.put(s1.charAt(i),hm.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int i=0; i<s2.length(); i++){
            if(hm.containsKey(s2.charAt(i))){
                hm.put(s2.charAt(i),hm.get(s2.charAt(i))-1);
            }
            else return false;
        }

        Set<Character> set = hm.keySet();
        for(char c : set){
            if(hm.get(c) != 0) return false;
        }
        return true;
    }
}
