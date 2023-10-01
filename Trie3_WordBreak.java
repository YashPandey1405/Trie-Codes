import java.util.*;

public class Trie3_WordBreak {
    static class Node {
        Node Children[] = new Node[26];
        boolean EndOfWord = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                Children[i] = null;
            }
        }
    }

    public static Node Root = new Node(); // Global Node.....

    // Time Complexity Of InsertNode() Function Is O(L) , L=Largest Word Length.....
    public static void InsertNode(String Word) {
        Node curr = Root;
        for (int level = 0; level < Word.length(); level++) {
            int idx = Word.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];
        }
        curr.EndOfWord = true;
    }

    // Time Complexity Of SearchKey() Function Is O(L) , L=Key Length.....
    public static boolean SearchKey(String Key) {
        Node curr = Root;
        for (int level = 0; level < Key.length(); level++) {
            int idx = Key.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];
        }
        return curr.EndOfWord == true;
    }

    // Time Complexity Of WordBreak() Function Is O(L) , L=Key Length.....
    public static boolean WordBreak(String Key) {
        if (Key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= Key.length(); i++) {
            boolean Case1 = SearchKey(Key.substring(0, i)); // Substring=(0 To i-1).....
            boolean Case2 = WordBreak(Key.substring(i)); // Substring=(i To size).....
            if (Case1 && Case2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String Words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < Words.length; i++) {
            InsertNode(Words[i]);
        }
        String Key = "ilikesamsung";
        boolean ans = WordBreak(Key);
        if (ans) {
            System.out.println("KEY '" + Key + "'' EXISTS IN THE GIVEN WORDS STRING");
        } else {
            System.out.println("KEY " + Key + " NOT EXISTS IN THE GIVEN WORDS STRING");
        }
    }
}