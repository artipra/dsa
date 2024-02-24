package string;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("1234561111111111654321"));
    }

    static boolean isPalindrome(String str){
        int m = str.length()/2;
        for(int i=0; i<m; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}
