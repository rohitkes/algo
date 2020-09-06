public class DemoTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("abdef");
        trie.insert("bfgh");
        trie.insert("ebcd");

//        System.out.println("abcd found: " + trie.searchWord("abcd"));
//        trie.deleteWord("abcd");
//        System.out.println("abcd found: " + trie.searchWord("abcd"));
        trie.searchPattern("..cd");
    }
}
