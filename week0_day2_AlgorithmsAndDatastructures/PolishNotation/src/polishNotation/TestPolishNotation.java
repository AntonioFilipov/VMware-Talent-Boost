package polishNotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPolishNotation {

    @Test
    public void test1() {
        assertEquals(40.0 , PolishNotation.calculate("*+35-72"), 0.01);
    }
    
    @Test
    public void test2() {
        assertEquals(3.0 , PolishNotation.calculate("/62"), 0.01);
    }

}
