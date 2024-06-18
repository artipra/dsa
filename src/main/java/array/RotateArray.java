package array;

public class RotateArray {
    public static void main(String[] args) {
//        int[] A = {1,1,4,9,4,7,1};
//        int b =9;
//        int n = A.length;
//        b = b%n;
//        int newArr[] = new int[n];
//        int j=0;
//        for(int i=n-b; i<n; i++){
//            System.out.println(i);
//            newArr[j++] = A[i];
//        }
//        j = b;
//        for(int i=0; i<n-b; i++){
//            newArr[j++] = A[i];
//        }
//        for(int a : newArr){
//            System.out.print(a+"commit");
//        }
         int A[] = {6,3,3,6,7,8,7,3,7};
         int B[][] = {{2,6},{4,7},{6,7}};
        solve(A,B);
    }


    public static int[] solve(int[] A, int[][] B) {
        int res[] = new int[B.length];
        int ps[] = new int[A.length];

        ps[0] = A[0]%2 == 0 ? 1 : 0;

        for(int i=1; i<A.length; i++){
            ps[i] = ps[i-1] + (A[i]%2 == 0 ? 1 : 0);
        }

        for(int i=0; i<B.length; i++){
            if(B[i][0] == 0) res[i] = ps[B[i][1]];
            else{
                res[i] = ps[B[i][1]]-ps[B[i][0]-1];
            }
        }
        return res;

    }
    public long[] rangeSum(int[] A, int[][] B) {
        long ps[] = new long[A.length];
        ps[0] = A[0];
        for(int i=1; i<A.length; i++){
            ps[i] = ps[i-1] + A[i];
        }
        long[] res = new long[B.length];
        int s=0,e=0;
        for(int i=0; i<B.length; i++){
            s = B[i][0];
            e = B[i][1];
            if(s == 0){
                res[i] = ps[e];
            }
            else{
                res[i] = ps[e]-ps[s-1];
            }
        }
        return res;

    }
}
