import java.util.*;

public class Trie7_LongestWordPrefix {
    static class Node {
        Node Children[] = new Node[26];
        boolean EndOfWord;
        int freq;

        public Node() {
            for (int i = 0; i < 26; i++) {
                Children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node Root = new Node();

    public static void InsertNode(String Word) {
        Node curr = Root;
        for (int i = 0; i < Word.length(); i++) {
            int idx = Word.charAt(i) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            } else {
                curr.Children[idx].freq++;
            }
            curr = curr.Children[idx];
        }
        curr.EndOfWord = true;
    }

    public static String ans = "";

    public static void LargestWord(Node Root, StringBuilder temp) {
        if (Root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (Root.Children[i] != null && Root.Children[i].EndOfWord == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                LargestWord(Root.Children[i], temp);
                // BackTrack Case.....
                temp.deleteCharAt(temp.length() - 1);

            }
        }
    }

    public static void main(String args[]) {
        String Words[] = { "a", "banana", "ap", "app", "appl", "apple", "apply" };
        for (int i = 0; i < Words.length; i++) {
            InsertNode(Words[i]);
        }
        LargestWord(Root, new StringBuilder(""));
        System.out.println("LONGEST WORD PREFIX IS ::: " + ans);
    }
}
