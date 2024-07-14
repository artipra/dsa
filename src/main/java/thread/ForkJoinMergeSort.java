package thread;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMergeSort {

    // Threshold for switching to insertion sort
    private static final int INSERTION_SORT_THRESHOLD = 10;

    // Main method to test the merge sort
    public static void main(String[] args) {
        int[] array = { 5, 2, 9, 1, 5, 6, 3, 10, 7 };
        System.out.println("Original Array: " + Arrays.toString(array));

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(array, 0, array.length - 1));

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    // RecursiveTask implementation for merge sort
    static class MergeSortTask extends RecursiveTask<Void> {
        private int[] array;
        private int left;
        private int right;

        public MergeSortTask(int[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected Void compute() {
            if (left < right) {
                int mid = (left + right) / 2;
                MergeSortTask leftTask = new MergeSortTask(array, left, mid);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, right);

                // Fork tasks
                leftTask.fork();
                rightTask.fork();

                // Join results
                leftTask.join();
                rightTask.join();

                // Merge sorted halves
                merge(array, left, mid, right);
            }
            return null;
        }

        // Merge function to merge two sorted halves
        private void merge(int[] array, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = left;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= right) {
                if (array[i] <= array[j]) {
                    temp[k++] = array[i++];
                } else {
                    temp[k++] = array[j++];
                }
            }

            while (i <= mid) {
                temp[k++] = array[i++];
            }

            while (j <= right) {
                temp[k++] = array[j++];
            }
            // Copy temp array back to original array
            System.arraycopy(temp, 0, array, left, temp.length);
        }
    }
}
