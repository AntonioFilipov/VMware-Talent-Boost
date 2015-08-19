package org.talentboost.validators;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NumberOfArgumentsValidatorTest {
    private List<String> list;
    
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
    }
    @Test
    public void testValidNumberOfArguments() {
        assertTrue(NumberOfArgumentsValidator.validate(list, 3));
    }
    
    @Test
    public void testInvalidNumberOfArguments() {
        assertFalse(NumberOfArgumentsValidator.validate(list, 2));
    }

}
