package array;

public class RotateArray {
    public static void main(String[] args) {
        int[] A = {1,1,4,9,4,7,1};
        int b =9;
        int n = A.length;
        b = b%n;
        int newArr[] = new int[n];
        int j=0;
        for(int i=n-b; i<n; i++){
            System.out.println(i);
            newArr[j++] = A[i];
        }
        j = b;
        for(int i=0; i<n-b; i++){
            newArr[j++] = A[i];
        }
        for(int a : newArr){
            System.out.print(a+"commit");
        }
    }

}
