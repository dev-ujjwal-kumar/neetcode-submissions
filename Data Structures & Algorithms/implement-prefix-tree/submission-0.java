public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isTerminal = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int i = c - 'a'; // finding index for char 
            if(curr.children[i] == null){ // Create a child if it doesn't exist
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i]; // move to the child node
        }
        curr.isTerminal = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(curr.children[i] == null){
                return false;
            }
            curr = curr.children[i];
        }
        return curr.isTerminal; // If marked as end of word only then return true els false.
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            int i = c - 'a';
            if(curr.children[i] == null){
                return false;
            }
            curr = curr.children[i];
        }

        return true; // for prefix we don't req. terminal node checking

    }
}
