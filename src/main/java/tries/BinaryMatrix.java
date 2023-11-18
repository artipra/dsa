package tries;

public class BinaryMatrix {
    static int count =0;
    static class TrieNode{
        TrieNode[] child = new TrieNode[2];
        boolean isEnd = false;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,0,0,1,0},{0,1,0,1,0},{1,1,0,1,1},{1,1,0,0,1},
                       {1,1,0,1,1},{1,0,0,1,0},{1,0,1,0,1},{0,0,1,1,0}};
        System.out.println(binaryMartix(arr));
    }
    static int binaryMartix(int [][] arr){
        TrieNode root = new TrieNode();
        for(int i=0; i<arr.length; i++){
            if(!search(arr[i],root)){
                insert(arr[i],root); count++;
            }
        }
        return count;
    }

    static boolean search(int arr[], TrieNode root){
        TrieNode current = root;
        for(int i=0; i<arr.length; i++){
            if(current.child[arr[i]] == null) return false;
            current = current.child[arr[i]];
        }

        return true;
    }

    static void insert(int arr[], TrieNode root){
        TrieNode current = root;
        for(int i=0; i<arr.length; i++){
            if(current.child[arr[i]] == null)current.child[arr[i]] = new TrieNode();
            current = current.child[arr[i]];
        }
        current.isEnd = true;
    }



}
