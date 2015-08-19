package TreeImplementationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import TreeImplementation.Mapper;
import TreeImplementation.WordProcessor;
import TreeImplementation.WordsTree;

public class TestMapper {

    private WordProcessor reader;
    private WordsTree tree;
    private Mapper map;
    
    @Before
    public void setUp() throws Exception {
        reader = new WordProcessor();
        tree = new WordsTree();
        map = new Mapper();
        
        reader.readFromFile("filteredWords");
        tree.addWords(reader.getWords());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidPhoneNumber() {
        map.mapNumberToWord("22s55", "", tree.getRoot());
    }
    
    @Test
    public void testContainingWord() {
        map.mapNumberToWord("2255", "", tree.getRoot());
        assertEquals("[balk, ball, calk, call]", map.getWords().toString());
    }
    
}
