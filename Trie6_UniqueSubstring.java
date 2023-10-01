public class Trie6_UniqueSubstring {
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

    public static int CountNodes(Node Root) {
        if (Root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (Root.Children[i] != null) {
                count += CountNodes(Root.Children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String args[]) {
        String str = "ababa";
        // Suffix --> Insert In Trie......
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            InsertNode(suffix);
        }
        int count = CountNodes(Root);
        System.out.println("THE UNIQUE SUB-STRING IN STRING '" + str + "' IS ::: " + count);
    }
}
