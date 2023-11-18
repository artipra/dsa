package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class AutoComplete
{
     /*1
       6 3
       abcd aecd abaa abef acdcc acbcc
       2 1 3 4 6 5
       ab abc a
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words;
        String [] prefixs;
        int [] weight;
        Pair[] pairs;
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            words = new String[n];
            weight = new int[n];
            prefixs = new String[m];
            pairs = new Pair[n];
            for (int w = 0; w < n; w++) {
                words[w] = sc.next();
            }
            for (int we = 0; we < n; we++) {
                weight[we] = sc.nextInt();
            }
            for(int p=0; p<m; p++){
                prefixs[p]=sc.next();
            }
          for(int pp=0; pp<n; pp++) pairs[pp] = new Pair(words[pp],weight[pp]);
          Arrays.sort(pairs,(a,b) -> a.weight-b.weight);

            Node root = new Node();
            for (int j = 0; j < pairs.length; j++) put(pairs[j].word, root, j);
            for (int j = 0; j < prefixs.length; j++) searching(prefixs[j], root, pairs);
        }
    }

    public static class Node {
        Node[] child;
        ArrayList< Integer > idx;
        boolean isEnd;
        Node() {
            child = new Node[26];
            idx = new ArrayList < > ();
            isEnd = false;
        }
    }

    public static class Pair {
        String word;
        int weight;
        Pair(String s, int w) {
            word = s;
            weight = w;
        }
    }

    static void put(String word, Node root, int idx) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (current.child[ch] == null) current.child[ch] = new Node();
            current = current.child[ch];
            if (current.idx.size() < 5) current.idx.add(idx);
        }
        current.isEnd = true;
    }

    static void searching(String prefix, Node root, Pair[] words) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (current.child[ch] == null) {
                System.out.println("-1 ");
                return;
            } else current = current.child[ch];
        }
        for (int index: current.idx) System.out.print(words[index].word + " ");
        System.out.println("");
    }

}


