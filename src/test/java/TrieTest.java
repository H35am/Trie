package java;

import nl.hr.cmi.Trie;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    Trie trie;

    @Before
    public void setup(){
        trie = new Trie();
    }


    @Test
    public void add_one_character(){
        trie.setData('a');
        assertEquals(trie.getData(), 'a');
    }

    @Test
    public void contains_one_character(){
        trie.data = 'a';

        assertTrue(trie.contains("a"));
        assertFalse(trie.contains("b"));
    }

    @Test
    public void containsTwoCharacters(){
        trie.data = 'a';
        Trie child1 = new Trie();
        child1.data = 'a';
        child1.isEnd = true;
        trie.children[0] = child1;

        assertTrue(trie.contains("aa"));
        assertFalse(trie.contains("a"));
    }

    @Test
    public void add_word(){
        trie.add("aap");
        assertEquals(true, trie.contains("aap"));
    }


    @Test
    public void add_constructedword_Word(){
        trie.add("home");
        trie.add("homeless");
        assertEquals(true, trie.contains("home"));
        assertEquals(true, trie.contains("homeless"));
    }

    @Test
    public void add_deviated_Words(){
        trie.add("home");
        trie.add("happy");
        assertEquals(true, trie.contains("home"));
        assertEquals(true, trie.contains("happy"));
    }

    @Test
    public void add_many_and_check_some_integration_test(){
        final String FILENAME = "OpenTaal-210G-basis-gekeurd.txt";

        try {
            Path path = Paths.get(FILENAME);
            //read the file and add every line to the trie
            Files.lines(path).forEach(line->trie.add(line));
        }catch(IOException ioe){
            System.err.println(ioe.getStackTrace());
        }

        assertTrue(trie.contains("Franstalige"));
        assertTrue(trie.contains("Fries"));
        assertTrue(trie.contains("arbeidsongeschiktheidsverzekeringsmaatschappij"));
        assertTrue(trie.contains("socialezekerheidsinstelling"));
        assertTrue(trie.contains("apachedans"));
    }

}
