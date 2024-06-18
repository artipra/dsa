package sorting;

//compare adjacent elements
public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 9, 6, 15, 99, -1};
        bubbleSort(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }


    static void bubbleSort(int [] arr){

        for(int i =0; i<arr.length; i++){
            for(int j=1; j<arr.length-i; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }

    }

    static void swap(int[] arr, int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
