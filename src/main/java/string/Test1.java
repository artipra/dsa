package string;

import javax.swing.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Test1 {


   static String reverse(String str){
      char[] arr1 = str.toCharArray();

      StringBuilder sb = new StringBuilder();
      for(int i =arr1.length-1; i>=0; i--){
         sb.append(arr1[i]);
      }

      return new String(sb);

   }
//   static String reverse(String str){
//      int m = str.length()/2;
//      StringBuilder sb = new StringBuilder();
//      for(int i =str.length()-1; i>=m; i--){
//         sb.append(str.charAt(i));
//      }
//      for(int i = m-1; i>=0; i--){
//         sb.append(str.charAt(i));
//      }
//      return sb.toString();
//   }

   public static void main(String[] args) {

      String s11 = "scaler";
      String s12 = new String("scaler");
      s12 = s12.intern();
       System.out.println(s11 == s12);
      System.out.println(reverse("abcd"));
      System.out.println(reverse("abcde"));
       String strs = "afdfdf,hfdjfhjdhfdjsf";
       StringTokenizer token = new StringTokenizer(strs,",");
       System.out.println(token.nextToken());
                                //Line1
       String str2 = new String("scaler").intern();      //Line2
       String str1 = "scaler";
       //  String str3 = str2.intern();                                       //Line 3
       System.out.println(str1 == str2);
     //  System.out.println(str3 == str2);

       StringJoiner joinStrings = new StringJoiner(",");
       // passing comma(,) and square-brackets as delimiter

       // Adding values to StringJoiner
       joinStrings.add("Scaler");
       joinStrings.add("By");
       joinStrings.add("InterviewBit");
       System.out.println(joinStrings);

       String s1 = new String("gfg").intern();
       String s2 = "gfg";
       String s3 = "gfggggggg";
       System.out.println(s3.substring(2));
       System.out.println("aaaaaa");
       System.out.println(s1 == s2);
       System.out.println("s1 equals s2 "+s1.equals(s2));
       System.out.println("bbbbbbb");
       System.out.println(s2 == s3);
       System.out.println("s2 equals s3 "+s2.equals(s3));
    }
}
