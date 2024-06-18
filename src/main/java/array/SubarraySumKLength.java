package array;

public class SubarraySumKLength {

    public static void main(String[] args) {

        int arr[] = {-3,4,-2,5,3,-2,8,2,-1,4};
        int ans[] = solve(arr,4);
        for(int a : ans){
            System.out.print(a+", ");
        }

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
