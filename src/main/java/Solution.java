import java.util.*;
public class Solution {


    public static void main(String[] args) {
        int arr[] = solve(222);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] solve(int A){
        ArrayList<Integer> res = new ArrayList();
        for (int i = 1; i <= A; i++) {
            if (isArmstrong(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    private static boolean isArmstrong(int a){
        int sum = 0;
        int lastDigit = 0;
        int i = a;
        while(i > 0){
            lastDigit = i%10;
            i = i/10;
            sum += (lastDigit*lastDigit*lastDigit);
        }
        if(sum == a) return true;
        return false;

    }


}
