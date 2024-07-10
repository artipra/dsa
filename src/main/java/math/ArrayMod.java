package math;

import java.util.ArrayList;

public class ArrayMod {


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(8);a.add(2);a.add(5);a.add(6);a.add(7);
        a.add(6);a.add(2);a.add(6);a.add(2);
        System.out.println(solve(a,10));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int ans=0; int n=A.size();
        int power = power(n,B);
        for(int i=0; i<n; i++){
//            System.out.println(0 %10);
//            System.out.println(A.get(i)%B +","+ power%B+","+A.get(i)%B * power%B);
            ans += (A.get(i)%B * power)%B;
            power = (power/10)%B;
        }
        return ans%B;
    }

    static int power(int p, int b){
        int pow = 1;
        for(int i=0; i<p; i++){
            pow *= 10;

        }
        return pow%b;
    }
}
