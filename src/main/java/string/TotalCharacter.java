package string;

public class TotalCharacter {

    public static void main(String [] args){
        System.out.println(count("abv fdfd dgfg "));
    }

    static int count(String str){
        int count =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ' '){count++;}
        }
        return count;
    }

}


