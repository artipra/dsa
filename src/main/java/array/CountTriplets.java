package array;

public class CountTriplets {

    public static void main(String[] args) {
       int arr[] = {6,3,11,25};
        System.out.println(solve(arr));
    }

    public static int solve(int[] A) {
        int l=0, r=0, left_count=0,right_count=0,ans=0;
        for(int i=1; i<A.length-1; i++){
            l = i-1;
            r = i+1;
            boolean leftFlag = false;
            boolean rightFlag = false;
            left_count=0;right_count=0;
            while(l >= 0){
                if(A[l] < A[i]){
                    leftFlag=true;
                    left_count++;
                }
                l--;
            }
            while(r < A.length){
                if(A[i] < A[r]){
                    rightFlag=true;
                    right_count++;
                }
                r++;
            }
            if(leftFlag && rightFlag)
            {
                ans += (left_count * right_count);
            }
        }

        return ans;
    }

}
