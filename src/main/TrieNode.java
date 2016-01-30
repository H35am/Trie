import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hesam Zarza - 0775768.
 */

public class TrieNode {

    private TrieNode parent;
    private TrieNode[] children;
    private char character;
    private boolean isLeaf;
    private boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
    }

    public TrieNode(char character) {
        this();
        this.setCharacter(character);
    }

    private int index;

    private int getCharPos(String word, int index)
    {
        char letter = word.charAt(index);
        int charPos =getIndex(letter);

        while(charPos == -1)
        {
            index++;
            this.index = index;
            charPos = getCharPos(word, index);
        }

        return charPos;
    }

    protected void addWord(String word) {
        isLeaf = false;
        this.index = 0;
        int charPos = getCharPos(word, this.index);
        char letter = (char)(charPos + 97);

        if (children[charPos] == null) {
            children[charPos] = new TrieNode(letter);
            children[charPos].parent = this;
        }

        if (word.length() > 1) {
            children[charPos].addWord(word.substring(this.index + 1));
        } else {
            children[charPos].isWord = true;
        }

    }

    protected TrieNode getNode(char c) {
        String temp = new String(new char[]{c});
        int charpos = getCharPos(temp,0);
        return children[charpos];
    }

    protected List getWords() {
        List list = new ArrayList();

        if (isWord) {
            list.add(toString());
        }

        if (!isLeaf) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    list.addAll(children[i].getWords());
                }
            }
        }
        return list;
    }

    public String toString() {
        if (parent == null) {
            return "";
        } else {
            return parent.toString() + new String(new char[]{getCharacter()});
        }

    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    //////////////////////////////////////
    // Utility methods
    /**
     * This returns which number in the alphabet the character is.
     * Non-letter characters will return -1
     *
     * example:
     * a = 0
     * b = 1
     * c = 2
     * ! = -1
     * @param character
     * @return
     */
    public static int getIndex(char character){
        if( Character.isAlphabetic(character)){
            String s = String.valueOf(character);
            s.toLowerCase();
            return Character.getNumericValue(s.toCharArray()[0]) - 10    ;
        }else{
            return -1;
        }
    }
}
