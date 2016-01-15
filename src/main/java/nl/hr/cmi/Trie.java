package nl.hr.cmi;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Trie {
    /**
     * The constructor
     */
    public Trie(){
        throw new NotImplementedException();
    }

    /**
     * Add a word to the tree
     * @param s
     */
    public void add(String s){
        throw new NotImplementedException();
    }

    /**
     * Check if the trie contains a word
     * @param word
     * @return
     */
    public boolean contains(String word){
        throw new NotImplementedException();
    }

    public char getData() {
        throw new NotImplementedException();
    }

    public void setData(char data) {
        throw new NotImplementedException();
    }

    public Trie getChild(char c){
        throw new NotImplementedException();
    }

    public Trie[] getChildren() {
        throw new NotImplementedException();
    }

    public void setChildren(Trie[] children) {
        throw new NotImplementedException();
    }

    public boolean isEnd() {
        throw new NotImplementedException();
    }

    public void setEnd(boolean end) {
        throw new NotImplementedException();
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
