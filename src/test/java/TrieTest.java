import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class TrieTest {
    Trie trie;
    TrieNode node;


    @Before
    public void setup() {
        trie = new Trie();
        node = new TrieNode();
    }


    @Test
    public void add_one_character() {
        node.setCharacter('a');
        assertEquals(node.getCharacter(), 'a');
    }
/*

    @Test
    public void contains_one_character() {
        trie.addWord("a");

        assertTrue(trie.contains("a"));
        assertFalse(trie.contains("b"));
    }

    @Test
    public void containsTwoCharacters() {
        trie.addWord("a");
        trie.addWord("a");
        assertTrue(trie.contains("aa"));
        assertFalse(trie.contains("a"));
    }
*/

    @Test
    public void add_word() {
        trie.addWord("aap");
        assertEquals(true, trie.contains("aap"));
    }


    @Test
    public void add_constructedword_Word() {
        trie.addWord("home");
        trie.addWord("homeless");
        assertEquals(true, trie.contains("home"));
        assertEquals(true, trie.contains("homeless"));
    }

    @Test
    public void add_deviated_Words() {
        trie.addWord("home");
        trie.addWord("happy");
        assertEquals(true, trie.contains("home"));
        assertEquals(true, trie.contains("happy"));
    }

    @Test
    public void add_many_and_check_some_integration_test() {
        final String FILENAME = "data/OpenTaal-210G-basis-gekeurd.txt";

        try {
            Path path = Paths.get(FILENAME);
            //read the file and add every line to the trie
            Files.lines(path).forEach(line -> trie.addWord(line));
        } catch (IOException ioe) {
            System.err.println(ioe.getStackTrace());
        }

        assertTrue(trie.contains("Franstalige"));
        assertTrue(trie.contains("Fries"));
        assertTrue(trie.contains("arbeidsongeschiktheidsverzekeringsmaatschappij"));
        assertTrue(trie.contains("socialezekerheidsinstelling"));
        assertTrue(trie.contains("apachedans"));
    }

}
