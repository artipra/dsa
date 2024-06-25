package array;

public class MaximumPositive {


    public static void main(String[] args) {
        int arr[] =  {8986143,-5026827,5591744,4058312,2210051,5680315,-5251946,-607433,1633303,2186575};
        int res[] = solve(arr);
        for(int a: res){
            System.out.println(a);
        }
    }
    public static int[] solve(int[] A) {
        int l=0, r=0,cl=0,fs=0,fe=0;
        int i=0;
        while(i < A.length){
            if(A[i] < 0) i++;
            else {
                l = i;
                while (i < A.length && A[i] > -1) {
                    i++;
                }
                if (cl < (i - l)) {
                    cl = i - l;
                    fs = l;
                    fe = i;
                }
            }
                l=i;
        }

        int res[] = new int[fe - fs];int k=0;
            for (int j = fs; j < fe; j++) {
                res[k++] = A[j];
            }

        return res;
    }
}
