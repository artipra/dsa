package sorting;


import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3,2,-1,4,-5,-525286399,156456456};//{2,4,1,9,6};
        arr = insertionSort2(arr);
        System.out.println(Arrays.toString(arr));


//        for(int a: arr){
//            System.out.print(a +" ");
//        }
    }


    static int[] insertionSort2(int arr[]){
        for(int i=1; i<arr.length; i++){
            int j=i;
            while(j > 0){
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                    j--;
                }
                else break;
            }

        }
        return arr;
    }



    static int[] insertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int j=i;
            while(j > 0){
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                }
                j--;
            }

        }
        return arr;
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }

}
