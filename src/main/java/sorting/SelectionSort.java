package sorting;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {
        int[] arr = {8,2,3,10,15};//{12,4,1,9,6};
        arr= selectionSort2(arr);
        System.out.println(Arrays.toString(arr));
//        for(int a: arr){
//            System.out.print(a +" ");
//        }
    }

    static int[] selectionSort(int [] arr){
        for(int i=0; i<arr.length-1; i++){
            int min_idx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min_idx]){
                    min_idx =j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        return arr;
    }

    static int[] selectionSort2(int [] arr){
        int n = arr.length-1;
        for(int i=0; i<n; i++){
            int max_idx = 0;
            for(int j=0; j<arr.length-i; j++){
                if(arr[j] > arr[max_idx]){
                    max_idx =j;
                }
            }
            int temp = arr[n-i];
            arr[n-i] = arr[max_idx];
            arr[max_idx] = temp;
        }
        return arr;
    }

}
