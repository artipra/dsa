package array;

import java.util.ArrayList;

public class leetcodeConsent {

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);list.add(2);list.add(1);list.add(4);list.add(1);list.add(4);
//        System.out.println(list);
//        list.remove(4);
//        System.out.println(list);
//        list.remove(4);
//        System.out.println(list);
        int arr[] = {1,9,8,3,10,5};
        System.out.println(minimumAverage(arr));
    }

    public static double minimumAverage(int[] nums) {

        ArrayList<Integer> arr = new ArrayList();
        int minIdx = -1,maxIdx=-1;
        double minAvg=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            arr.add(nums[i]);
        }

        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int size = arr.size();
        for(int i=0; i<size/2; i++){
            int j=0,k=0;
            minIdx=-1;maxIdx=-1;min=Integer.MAX_VALUE;max=Integer.MIN_VALUE;
            for(; j<arr.size(); j++){
                if(arr.get(j) < min){
                    min = arr.get(j);
                    minIdx=j;
                }
            }
            for(; k<arr.size(); k++){
                if(arr.get(k) > max){
                    max=arr.get(k);
                    maxIdx = k;
                }
            }
            arr.remove(Integer.valueOf(min));
            arr.remove(Integer.valueOf(max));
            minAvg = Math.min(minAvg,(min+max)/2.0);
        }

        return minAvg;
    }

}
