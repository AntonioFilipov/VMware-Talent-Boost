package TreeImplementationTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TreeImplementation.WordProcessor;

public class TestWordsProcessor {

    private  WordProcessor reader;
    @Before
    public void setUp() throws Exception {
        reader = new WordProcessor();
        reader.readFromFile("filteredWords");
    }

    @Test
    public void testValidWord() {
        assertTrue(reader.getWords().contains("abandonment"));
    }
    
    @Test
    public void testValidWordDifferentEncoding() {
        assertTrue(reader.getWords().contains("éclair"));
    }
    
    @Test
    public void testInValidWord() {
        assertFalse(reader.getWords().contains("abandment"));
    }

}
