package thread;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMergeSort {

    public static void main(String[] args) {
     int [] array = {1,5,9,3,6,7,1,5,8,2,3,8};
     ForkJoinPool pool = new ForkJoinPool();
     pool.invoke(new MergeSortTask(array,0,array.length-1));
     System.out.println(Arrays.toString(array));
    }

static class MergeSortTask extends RecursiveTask<Void>{
        private int arr[];
        private int left=0;
        private int right=0;
    MergeSortTask(int arr[],int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }
    @Override
    protected Void compute() {
        if(left < right){
            int mid = (left+right)/2;
            MergeSortTask leftTask = new MergeSortTask(arr,left,mid);
            MergeSortTask rightTask =new MergeSortTask(arr,mid+1,right);

            leftTask.fork();
            rightTask.fork();

            leftTask.join();
            rightTask.join();

            merge(arr,left,mid,right);
        }
        return null;
    }
    void merge(int arr[], int left,int mid, int right){
    int i=left, j = mid+1,idx=0;
    int result[] = new int[right-left+1];
    while(i <= mid && j <= right){
     if(arr[i] > arr[j])result[idx++] = arr[j++];
     else result[idx++] = arr[i++];
    }
     while(i <= mid){
      result[idx++] = arr[i++];
     }
     while(j <= right){
          result[idx++] = arr[j++];
     }
      System.arraycopy(result, 0, arr, left, result.length);
    }
}
}
