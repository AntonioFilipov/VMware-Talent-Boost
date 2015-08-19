package org.talentboost.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlphanumericCharactersAndSpaceValidatorTest {

    private AlphanumericCharactersAndSpaceValidator validator;
    
    @Before
    public void setUp() throws Exception {
       validator = AlphanumericCharactersAndSpaceValidator.getInstance();
    }

    @Test
    public void testValidOnlyLetters() {
        String validOnlyLetters = "AzdDd";
        assertTrue(validator.validate(validOnlyLetters));
    }
    
    @Test
    public void testValidOnlyDigits() {
        String validOnlyDigits = "0";
        
        assertTrue(validator.validate(validOnlyDigits));
    }
    
    @Test
    public void testValidLetterAndDigits() {
        String validMixed = "Az092d";
        
        assertTrue(validator.validate(validMixed));
    }
    
    @Test
    public void testValidContainingSpace() {
        String validWithSpace = "Az09 2d";
        
        assertTrue(validator.validate(validWithSpace));
    }
    
    @Test
    public void testInvalidEmpty() {
        String invalidEmptyString = "";
        
        assertFalse(validator.validate(invalidEmptyString));
    }
    
    @Test
    public void testInvalidContainingSpecialCharacters() {
        String invalidContainingSpecialCharacters = "*z0%s92d";
        
        assertFalse(validator.validate(invalidContainingSpecialCharacters));
    }

}
