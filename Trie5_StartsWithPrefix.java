public class Trie5_StartsWithPrefix {
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

    // Time Complexity Of StartsWithPrefix() Function Is O(L) , L=Prefix.Length()
    public static boolean StartsWithPrefix(Node Root, String Prefix) {
        Node curr = Root;
        for (int i = 0; i < Prefix.length(); i++) {
            int idx = Prefix.charAt(i) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];
        }
        return true;
    }

    public static void main(String args[]) {
        String Word[] = { "apple", "app", "mango", "man", "women" };
        for (int i = 0; i < Word.length; i++) {
            InsertNode(Word[i]);
        }
        String Prefix = "app";
        boolean ans = StartsWithPrefix(Root, Prefix);
        System.out.println(Prefix + " PRESENT IN THE WORDS ARRAY ::: " + ans);

    }
}
