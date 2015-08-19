package TreeImplementationTests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import TreeImplementation.WordsTree;

public class TestWordsTree {

    private WordsTree tree;
    private HashSet<String> set;
    @Before
    public void executedBeforeEach() throws Exception {
        tree = new WordsTree();
        set = new HashSet<String>();
        set.add("go");
        set.add("gone");
        set.add("goned");
        set.add("goal");
        set.add("car");
        set.add("carrot");
    }

    @Test
    public void testValidWordWithoutContainingOtherWord() {
        tree.addWords(set);
        assertTrue(tree.isWord("car"));
    }
    
    @Test
    public void testValidWordThatContainOtherWord() {
        tree.addWords(set);
        assertTrue(tree.isWord("carrot"));
    }
    
    @Test
    public void testValidWordThatIsInOtherValidWord() {
        tree.addWords(set);
        assertTrue(tree.isWord("gone"));
    }
    
    @Test
    public void testInValidWord() {
        tree.addWords(set);
        assertFalse(tree.isWord("carr"));
    }

}
