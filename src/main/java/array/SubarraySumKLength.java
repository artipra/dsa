package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarraySumKLength {

    public static void main(String[] args) {

//        int arr[] = {-3,4,-2,5,3,-2,8,2,-1,4};
//        int ans[] = solve(arr,4);
//        for(int a : ans){
//            System.out.print(a+", ");
//        }

        List<Integer> a = Arrays.asList(6,3,3,6,7,8,7,3,7);
        System.out.println(solve1(a,2,10));
    }
    public static int solve1(List<Integer> A, int B, int C) {
        int sum =0;
        for(int r=0; r<A.size(); r++){
            sum += A.get(r);
            if(r >= B) sum -= A.get(r-B);
            if(sum == C && r >= B-1) {
                return 1;
            }
        }
        return 0;
    }

    //O(n-k+1)
        public static int[] solve(int[] A, int B) {
            int sum =0;
            int ans[] = new int[A.length-B+1];
            for(int i=0; i<B; i++){
                sum += A[i];
            }
            ans[0] = sum;
            int s=1, e = B;
            while(e < A.length){
               sum  = sum - A[s-1] + A[e];
                ans[s] = sum;
                s++;e++;
            }
            return ans;
        }



}
