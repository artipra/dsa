package array;

public class Minswaps {

    public static void main(String[] args) {
//        System.out.println(5/13);
//        System.out.println(Math.pow(6,0));
       int arr[] = {31,98,58,86,36,31,3,22,4,17,51,33,56,7,91,17,59,66,54,67,55,41,58,24,100,1,98,68,21,33,27,67,20,66,20,100,36,89,20,15,13,26,
        11,29,99,36,39,49,74,77,54,66,30,21,14,18,83,72,10,22,53,83,60,9,68,56,9,21,77,44,45,61,97,82,35,16,38,95,55,11,46,77,25,3,44};
       int b=18;

        int minElements = 0, s=0,countInWindow = 0,ans = Integer.MAX_VALUE,e=0;
        for(int a : arr){
            if(a < b) minElements++;
        }

        System.out.println(minElements);
        for(int i =0; i<minElements; i++){
            if(arr[i] < b){
                //System.out.print(arr[i]+",");
                countInWindow++;
            }
            System.out.print(arr[i]+",");
        }

        System.out.println("countInWindow----"+countInWindow);
        ans = minElements-countInWindow;
        System.out.println("ans----"+ans);
        for(int i=minElements; i<arr.length; i++){
            if(arr[s] < b) countInWindow--;
            if(arr[i] < b) countInWindow++;
            System.out.println("countInWindow in each window----"+countInWindow);
            ans = Math.min(ans,minElements-countInWindow);
            s++;
        }



        System.out.println(ans);
    }
}
