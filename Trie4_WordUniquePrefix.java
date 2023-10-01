public class Trie4_WordUniquePrefix {
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

    public static void FindPrefix(Node Root, String ans) {
        if (Root == null) {
            return;
        }
        if (Root.freq == 1) {
            System.out.print(ans + "  ");
            return;
        }
        for (int i = 0; i < Root.Children.length; i++) {
            if (Root.Children[i] != null) {
                FindPrefix(Root.Children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String args[]) {
        String arr[] = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < arr.length; i++) {
            InsertNode(arr[i]);
        }
        Root.freq = -1;
        System.out.print("THE UNIQUE PREFIX ARE ::: ");
        FindPrefix(Root, "");
    }
}
