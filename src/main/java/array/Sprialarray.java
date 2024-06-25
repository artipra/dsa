package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Sprialarray {

    public static void main(String[] args) {
        System.out.println(43/6);
        double d = 46.00/6;
        System.out.println(d);
        int arr[][] = new int[3][3];int count=1;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j< arr[i].length; j++){
                arr[i][j] = count++;
            }
        }
      //  Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::print);
       // sprialPrint(arr);
        //generateMatrix(2);
//        for(int[] a: arr){
//            for(int val: a){
//                System.out.print(val+" ");
//            }
//            System.out.println();
//        }
        System.out.println(generateMatrix2(2));
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix2(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        for(int i=0; i<A; i++){
            res.add(new ArrayList<Integer>());
        }

        for(ArrayList<Integer> list : res){
            for(int i=0; i<A; i++){
                list.add(0);
            }
        }

        int i =0,row=0,col=0,number=1;
        while(i<A/2){
            for(; col<A-1-i; col++)
                res.get(row).set(col,number++);
            for(; row<A-1-i; row++)
                res.get(row).set(col,number++);
            for(; col>i; col--)
                res.get(row).set(col,number++);
            for(; row>i; row--)
                res.get(row).set(col,number++);
            i++;
            row = i;
            col = i;
        }
        if(A%2 != 0)res.get(row).set(col,number);
        return res;
    }

    static void sprialPrint(int [][] arr){
        int i=0,j=0,count=1,b=0,n=arr.length;
        while(b<n/2){
            for(; j<n-1-b; j++){
                System.out.print(arr[i][j]+" ");
            }
            for(; i<n-1-b; i++){ System.out.print(arr[i][j]+" ");}
            for(; j>b; j--){
                System.out.print(arr[i][j]+" ");
            }
            for(; i>b; i--){ System.out.print(arr[i][j]+" ");}
            b++;
            i=b;j=b;
        }
        if(n%2!=0)System.out.print(arr[n/2][n/2]);
    }
    public static int[][] generateMatrix(int A) {
        int i=0,j=0,count=1,b=0,n=A;
        int arr[][] = new int[A][A];
        while(b<n/2){
            for(; j<n-1-b; j++){arr[i][j]=count++;}
            for(; i<n-1-b; i++){arr[i][j]=count++;}
//            System.out.println(count);
            for(; j>b; j--){
//                            System.out.println(count);
                arr[i][j]=count++;
//                            System.out.println(count);
            }
            for(; i>b; i--){arr[i][j]=count++;}

            b++;
            i=b;j=b;
        }
        if(A%2!=0)arr[n/2][n/2]=count;
        return arr;
    }

}
