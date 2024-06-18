package subarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class ZeroRowCol {

    public static void main(String[] args) {
//        int[][] arr = {{51,21,90,38,57,12,11,1,68,60},
//                {81,24,63,97,75,70,23,91,39,84},
//                {0,21,97,12,46,48,50,3,57,69},
//                {44,8,42,34,99,0,98,10,53,67},
//                {23,34,43,86,31,18,9,54,61,48},
//                {90,61,21,87,26,67,88,28,70,45},
//                {98,14,5,92,1,4,44,99,67,98},
//                {18,42,32,61,80,64,32,89,70,93},
//                {89,61,7,10,0,85,29,40,13,0},
//                {85,63,66,43,56,67,99,0,67,66}};
//        int[][] res = solve(arr);
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a1  = new ArrayList<>();
        a1.add(1);a1.add(2);a1.add(3);a1.add(4);
        ArrayList<Integer> a2  = new ArrayList<>();
        a2.add(5);a2.add(6);a2.add(7);a2.add(8);
        ArrayList<Integer> a3  = new ArrayList<>();
        a3.add(9);a3.add(2);a3.add(0);a3.add(4);
        A.add(a1);A.add(a2);A.add(a3);
        ArrayList<ArrayList<Integer>> b =  solve1(A);
        for(ArrayList<Integer> child : b){
            System.out.println(child);
        }

//        String print = "[";
//        for(int i=0; i<res.length; i++){
//            print += "[ ";
//            for(int j=0; j<res[i].length; j++){
//               print += res[i][j]+",";
//            }
//            print += " ],\n";
//        }
//        print += "]";
//        System.out.println(print);

    }


    public static ArrayList<ArrayList<Integer>> solve1(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();
        int m = A.get(0).size();
        ArrayList<ArrayList<Integer>> res = new ArrayList();

        for(int i =0; i<n; i++){
            res.add(new ArrayList());
            for(int j=0; j<m; j++){
                res.get(i).add(-1);
            }
        }
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A.get(i).get(j) == 0){
                    for(int row = 0; row<n; row++){
                        res.get(row).set(j,0);
                        res.get(i).set(row,0);
                    }
                }
                else{
                    if(res.get(i).get(j) != 0)res.get(i).set(j,A.get(i).get(j));
                }
            }
        }

        return res;
    }


    public static int[][] solve(int[][] A) {
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
  //  int[][] res = Arrays.stream(A).map(int[]::clone).toArray(int[][]::new);
        for(int i=0; i<A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0) {
                    ArrayList<Integer> val = hm.get(i) == null ? new ArrayList() : hm.get(i);
                    val.add(j);
                    hm.put(i, val);
                }
            }
        }

        for(int i=0; i<A.length; i++){
            if(hm.containsKey(i)) {
                ArrayList<Integer> values = hm.get(i);
                for(int j=0; j<values.size(); j++){
                    zeroRowAndCol(A,i,values.get(j));
                }
            }

        }

       return A;
}

    static void zeroRowAndCol(int[][] A, int i,int j){
        for(int j1=0; j1<A[i].length; j1++){
            A[i][j1] = 0;
        }
        for(int i1=0; i1<A.length; i1++){
            A[i1][j] = 0;
        }
    }



//    public static int[][] solve(int[][] A) {
//        int[][] res = Arrays.stream(A).map(int[]::clone).toArray(int[][]::new);
//
//        for(int i=0; i<A.length; i++){
//            for(int j=0; j<A[i].length; j++){
//                if(A[i][j] == 0) zeroRowAndCol(res,i,j);
//            }
//        }
//       return res;
//    }
//
//    static void zeroRowAndCol(int[][] A, int i,int j){
//        for(int j1=0; j1<A[i].length; j1++){
//            A[i][j1] = 0;
//        }
//        for(int i1=0; i1<A.length; i1++){
//            A[i1][j] = 0;
//        }
//
//    }
}
