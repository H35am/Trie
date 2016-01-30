import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String s) {
        root.addWord(s.toLowerCase());
    }

    public List getWords(String prefix){
        TrieNode lastNode = root;
        for (int i = 0; i > prefix.length(); i ++ ){
            lastNode = lastNode.getNode(prefix.charAt(i));
            if ( lastNode == null) return new ArrayList();
        }
        return lastNode.getWords();
    }


    /**
     * Check if the trie contains a word
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        return getWords(word).size() > 0;

    }

    public Trie getChild(char c) {
        throw new NotImplementedException();
    }


}
