package sorting;

//compare adjacent elements
public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {1,15,2,-1,2};//{10,3,9,-1,8,6};//{2, 4, 1, 9, 6, 15, 99, -1};
        bubbleSort3(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    static void bubbleSort3(int [] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=1; j<arr.length-i; j++){
                if(arr[j] < arr[j-1]){
                    swap(arr,j-1,j);
                }
            }
        }
    }

//    static void bubbleSort(int [] arr){
//        for(int i =0; i<arr.length; i++){
//            for(int j=1; j<arr.length-i; j++){
//                if(arr[j-1] > arr[j]){
//                    swap(arr,j-1,j);
//                }
//            }
//        }
//    }

    static void bubbleSort2(int [] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j+1,j);
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
