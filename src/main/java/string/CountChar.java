package string;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountChar {

    public static void main(String[] args) {
        System.out.println(countChar("abababcdee",'c'));
        System.out.println(countChar2("abababcdee",'b'));

    }


    public static int countChar(String str, char c){
        int count =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == c){
                count++;
            }
        }
        return count;
    }


    public static Long countChar2(String str, char c){
        Map<Character,Long> feqChar = str.chars().mapToObj(d -> (char)d).filter(s -> s.equals(c)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return feqChar.get(c);
    }
}
