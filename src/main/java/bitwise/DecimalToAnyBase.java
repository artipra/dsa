package bitwise;

public class DecimalToAnyBase {

    public static void main(String[] args) {
        int i=4;
        System.out.println(i);
        i = i<<31;
        System.out.println(i);
        //System.out.println(DecimalToAnyBase(4,2));
    }


    public static int DecimalToAnyBase(int A, int B) {
        StringBuffer sb = new StringBuffer();

        while(A>1){
            int div = A%B;
            sb = sb.append(div);
            A = A/B;
        }
        sb.append(A);
        sb.reverse();
        String str1 = sb.toString();
        return Integer.valueOf(str1);
    }

}
