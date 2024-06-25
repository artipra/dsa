package array;

public class longestConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(solve("11010110000000000"));
    }
    public static int solve(String A) {
        int zeros = 0, ones = 0,l=0,r=0,max=0,left_count=0,right_count=0,ans=Integer.MIN_VALUE;

        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == '0')zeros++;
        }
        if(zeros == A.length()) return 0;

        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == '1')ones++;
        }
        if(ones == A.length()) return A.length();

        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='0'){
                l = i-1;
                r=i+1;
                left_count=0;right_count=0;
                while(l >= 0){
                    if(A.charAt(l)=='1')left_count++;
                    else break;
                    l--;
                }
                while( r < A.length()){
                    if(A.charAt(r)=='1')right_count++;
                    else break;
                    r++;
                }
                if(ans < left_count+right_count+1) ans = left_count+right_count+1;
            }
        }
        return ans;
    }
}
