import java.util.*;

public class Trie1_TriesCode {
    static class Node {
        Node Children[] = new Node[26];
        boolean EndOfWord = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                Children[i] = null;
            }
        }
    }

    public static Node Root = new Node();

    // Time Complexity Of InsertNode() Function Is O(L) , L=Largest Word Length.....
    public static void InsertNode(String Word) {
        Node curr = Root;
        for (int level = 0; level < Word.length(); level++) {
            int idx = Word.charAt((level) - 'a');
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];
        }
        curr.EndOfWord = true;
    }

    public static void main(String args[]) {
        String Words[] = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < Words.length; i++) {
            InsertNode(Words[i]);
        }
    }
}
