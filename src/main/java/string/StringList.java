package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringList {

    public static void main(String[] args) {
     List<String> list = Arrays.asList("cat","ball");
        System.out.println(stringListCheck(list,"tdlgbcgta"));
    }


    static List<Boolean> stringListCheck(List<String> list , String str){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            hm.put(str.charAt(i),hm.getOrDefault(hm.get(str.charAt(i)),0)+1);
        }
        //HashMap<Character,Integer> hm1 = new HashMap<>(hm);
        List<Boolean> res = new ArrayList<>();boolean flag =true;
        for(int i=0; i<list.size(); i++){
            HashMap<Character,Integer> hm1 = new HashMap<>(hm);
            flag=true;
            for(int j =0; j<list.get(i).length(); j++){
             if(!hm1.containsKey(list.get(i).charAt(j))){
                 flag = false;break;
             }
             else{
                 int val = hm1.get(list.get(i).charAt(j));
                 if(val == 0) hm1.remove(list.get(i).charAt(j));
                 hm1.put(list.get(i).charAt(j),val==0?0:val-1);
             }
            }
            if(!flag) res.add(false);
            else res.add(true);
        }
       return res;
    }
}
