package array;

public class JosephusProblem {

    public static void main(String[] args) {
        System.out.println(solve(9));
    }

    public static int solve(int A) {
        int nearestPower = 1;
        while(nearestPower < A){
            nearestPower *= 2;
        }
        nearestPower = nearestPower/2;
        return (A-nearestPower)*2+1;
    }

}
