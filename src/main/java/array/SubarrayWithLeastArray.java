package array;

public class SubarrayWithLeastArray {

    public static void main(String[] args) {
        int[] arr = {3,16,11,13,19,17,11,4,9,9,6,7,3,6,12,3,4,15,5,19};
        System.out.println(solve(arr,1));
    }

    public static int solve(int[] A, int B) {
        int l=0,r=0,min_start_idx=0;
        double ans = 0,sum=0;
        for( ; r<B; r++)sum += A[r];
        ans = sum/B;
        System.out.println("ans "+ans);
        l = l+1;
        while(r < A.length){
            sum = sum -A[l-1] +A[r];
            if(ans > (sum/B)){
                min_start_idx=l;
                System.out.println("ans "+sum/B);
                ans = Math.min(ans,(sum/B));
            }
            r++;l++;

        }

        return min_start_idx;

    }
}
