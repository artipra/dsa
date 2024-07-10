package sorting;

import java.util.ArrayList;

public class SortByColor {


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);A.add(1);A.add(2);A.add(0);A.add(1);A.add(2);
        sortColors(A);
    }


    public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int l=0,e=A.size()-1;
        while(l < e){
            while(A.get(l) == 0) l++;
            while(A.get(e) != 0) e--;
            if(l < e) swap(A,l,e);
        }
        l=0;e=A.size()-1;
            while(l < e){
              while(A.get(l) != 2) l++;
              while(A.get(e) == 2) e--;
              if(l < e)swap(A,l,e);
          }
        return A;
    }


    static void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }
}
