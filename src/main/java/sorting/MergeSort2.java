package sorting;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int arr[] = {830,15,3,9,-1,8,6};
        arr = mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }


    static int[] mergesort(int [] arr){
        return mergeHelper(arr,0,arr.length-1);
    }

    private static int[] mergeHelper(int[] arr, int s, int e) {
        if(s < e){
           int mid = (s+e)/2;
            mergeHelper(arr,s,mid);
            mergeHelper(arr,mid+1,e);
            arr = merge(arr,s,mid,e);
        }
        return arr;
    }

    static int[] merge(int [] arr, int s , int m, int e){
        int i = s;
        int j = m+1;
        int idx =0;
        int k=0;
        int [] new_arr = new int[e-s+1];
        while(i <= m && j <= e){
            if(arr[i] < arr[j]) new_arr[idx++] = arr[i++];
            else new_arr[idx++] = arr[j++];
        }
        while(i <= m){
            new_arr[idx++] = arr[i++];
        }
        while(j <= e){
            new_arr[idx++] = arr[j++];
        }
        for(int s1 = 0; s1<(e-s+1); s1++){
            arr[s1+s] = new_arr[s1];
        }
        return arr;
    }
}
