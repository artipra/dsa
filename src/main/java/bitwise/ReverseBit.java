package bitwise;

public class ReverseBit {

    public static void main(String[] args) {
        System.out.println(8/10);
        reverse(3);
    }

    public static  long reverse(long A) {
        long rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((A & (1 << i)) != 0)
                rev |= 1;
        }
        return rev;
    }
}
