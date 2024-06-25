package array;

import java.util.ArrayList;

public class SumQQueries {

    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>();
        ArrayList<ArrayList<Integer>> B= new ArrayList<>();
        //16,3,3,6,7,8,17,13,7
        A.add(16);A.add(3);A.add(3);A.add(6);A.add(7);A.add(8);
        A.add(17);A.add(13);A.add(7);
        ArrayList<Integer> b1 = new ArrayList<>();
        b1.add(2);b1.add(6);
        ArrayList<Integer> b2 = new ArrayList<>();
        b2.add(4);b2.add(7);
        ArrayList<Integer> b3 = new ArrayList<>();
        b3.add(6);b3.add(7);
        B.add(b1);B.add(b2);B.add(b3);

        System.out.println(solve(A,B));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> ps = new ArrayList<Integer>();
        ps.add(A.get(0));

        for(int i=1; i<A.size(); i++){
            if(i%2==0){
                int val = ps.get(i-1)+A.get(i);
                ps.add(val);
            }
            else{
                ps.add(ps.get(i-1));
            }
        }

        for(int i=0; i<B.size(); i++){
            if(B.get(i).get(0) == 0) res.add(ps.get(B.get(i).get(1)));
            else {
              //  int a = ps.get(B.get(i).get(1));
                //int b = ps.get(B.get(i).get(0)-1);
                res.add(ps.get(B.get(i).get(1))-ps.get(B.get(i).get(0)-1));
            }
        }
        return res;
    }
}
