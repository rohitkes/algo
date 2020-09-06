/**
 * DateCreated 06/09/2020
 * author rohit
 */
public class Trie {
    public TriedNode root = new TriedNode();
    public void insert(String buffer) {
        TriedNode current = root;
        for(int i = 0 ; i < buffer.length(); i++) {
            char ch = buffer.charAt(i);
            TriedNode node = current.children.get(ch);
            if(node == null) {
                node = new TriedNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public boolean search(TriedNode root, String  word, int index) {

        // If end of word and endOfWord = true
        if(index == word.length()) {
            return root.endOfWord;
        }
        char ch = word.charAt(index);
        TriedNode node = root.children.get(ch);
        // If character does not exists
        if(node == null)
            return false;
        return search(node, word, index +1);
    }

    public boolean delete(TriedNode current, String  word, int index) {
        if(word.length() == index) {
            if(!current.endOfWord)
                return false;
            current.endOfWord = false;
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TriedNode node = current.children.get(ch);
        if(node == null) {
            return false;
        }
        boolean searchFound = delete(node, word, index + 1);
        if(searchFound) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }
    public boolean searchWord(String word)
    {
        return search(root, word, 0);
    }

    public boolean deleteWord(String word) {
        return delete(root, word, 0);
    }
}
