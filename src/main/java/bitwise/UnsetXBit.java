package bitwise;

public class UnsetXBit {

    public static void main(String[] args) {
        solve(53,5);
    }

    public static long solve(long A, int B) {
        long ans = A;
        for(int i=0; i<B; i++){
            if((A|(1L<<i)) == A){
                System.out.println(ans);
                System.out.println(1L<<B);
                ans -= (1L<<i);
            }
        }
        return ans;
    }
}   
