package sorting;

public class MergeSort {

    public static void main(String[] args) {
        int [] arr = {2,4,1,9,6};
        mergeSort(arr,0,arr.length-1);
        for(int a : arr){
            System.out.print(a +" ");
        }
    }

    static void mergeSort(int[] arr,int s, int e){
        if(s >= e) return;

            int mid = (s+e)/2;
            mergeSort(arr,s,mid);
            mergeSort(arr,mid+1,e);
            merge(arr,s,mid+1,e);

    }

    static void merge(int arr[], int s, int mid, int e){
        int i = s;
        int j = mid;
        int idx =0;
        int result[] = new int[e-s+1];
        while(i < mid && j <= e){
            if(arr[i] <= arr[j]){
                result[idx++] = arr[i];
                i++;
            }
            else{
                result[idx++]  = arr[j];
                j++;
            }
        }

        while(i < mid) {result[idx++] = arr[i];i++;}
        while(j <= e) {result[idx++] = arr[j];j++;}

        for(int p =0; p<(e-s+1); p++){
           arr[s+p] = result[p];
        }
    }


}
