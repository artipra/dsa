package sorting;

public class SelectionSort {


    public static void main(String[] args) {
        int[] arr = {12,4,1,9,6};
        arr= selectionSort(arr);
        for(int a: arr){
            System.out.print(a +" ");
        }
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
}
