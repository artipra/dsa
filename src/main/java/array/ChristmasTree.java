package array;

import java.util.ArrayList;

public class ChristmasTree {

    public static void main(String[] args) {
      ArrayList<Integer> a = new ArrayList<>();
      a.add(5);a.add(9);a.add(10);a.add(4);a.add(7);a.add(8);
      ArrayList<Integer> b = new ArrayList<>();
      b.add(5);b.add(6);b.add(4);b.add(7);b.add(2);b.add(5);
        System.out.println(solve(a,b));
    }


    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = Integer.MAX_VALUE,left_cost = Integer.MAX_VALUE,right_cost = Integer.MAX_VALUE,curr_ele=0;
        for(int i =1; i<A.size()-1; i++){
            left_cost = Integer.MAX_VALUE;
            right_cost = Integer.MAX_VALUE;
            curr_ele=A.get(i);
            for(int j =0; j<i; j++){
                if(A.get(j) < curr_ele && left_cost > B.get(j)){
                    left_cost = B.get(j);
                }
            }
            curr_ele=A.get(i);
            for(int r = i+1; r<A.size(); r++){
                if(A.get(r) > curr_ele && right_cost > B.get(r)){
                    right_cost = B.get(r);
                }
            }
            if(left_cost != Integer.MAX_VALUE && right_cost != Integer.MAX_VALUE)
               ans = Math.min(ans,(B.get(i)+left_cost+right_cost));
        }

        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
