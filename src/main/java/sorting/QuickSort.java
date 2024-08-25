package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {125896,10,3,9,-1,8,9,6,8,22,-8,56,-56};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int arr[]){
       quickSortHelper(arr,0,arr.length-1);
    }

    static void quickSortHelper(int arr[], int s, int e){
        if(s >= e) return;
        int m = (s+e)/2;
        int p = arr[m];
        p = partition(arr,p,s,e);
        quickSortHelper(arr,s,p-1);
        quickSortHelper(arr,p+1,e);
    }

    private static int partition(int[] arr, int p, int s,int e) {
        while(s <= e){
            if(arr[s] <= p) s++;
            else if(arr[e] > p)
                e--;
            else{
                swap(arr,s,e);s++;e--;
            }
        }
        return e;
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

}
