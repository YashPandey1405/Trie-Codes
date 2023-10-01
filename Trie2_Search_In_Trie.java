import java.util.*;

public class Trie2_Search_In_Trie {
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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String Words[] = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < Words.length; i++) {
            InsertNode(Words[i]);
        }
        System.out.print("ENTER THE KEY YOU WANT TO SEARCH IN THE TRIE ::: ");
        String Key = sc.next();
        boolean Found = SearchKey(Key);
        if (Found) {
            System.out.println("KEY " + Key + " FOUND IN THE TRIE");
        } else {
            System.out.println("KEY " + Key + " NOT FOUND IN THE TRIE");
        }

    }
}