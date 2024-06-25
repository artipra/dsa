package array;

import java.util.ArrayList;

public class SubarrayWithLeastAvg {

    public static void main(String[] args) {
       // int[] arr = {1,2,3,4,5,6};
       // [18,11,16,19,11,9,8,15,3,10,9,20,1,19]
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(18);arr.add(11);arr.add(16);arr.add(19);
        arr.add(11);arr.add(9);arr.add(8);arr.add(15);
        arr.add(3);arr.add(10);
        arr.add(9);arr.add(20);
        arr.add(1);arr.add(19);

        System.out.println(solve1(arr,1));
    }

    public static int solve1(ArrayList<Integer> A, int B) {
        int sum = 0, avg = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (i >= B) sum -= A.get(i - B);
            if (avg > sum && i >= B - 1) {
                avg = sum;
                if (i == B-1) index = 0;
                else index = i - B;
            }
        }
        return index;
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
