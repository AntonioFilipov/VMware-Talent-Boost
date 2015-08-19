package org.talentboost.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlphanumericCharacterValidatorTest {
    private AlphanumericCharacterValidator validator;
    
    @Before
    public void setUp() throws Exception {
        validator = AlphanumericCharacterValidator.getInstance();
    }

    @Test
    public void testValidOnlyLetters() {
        String validOnlyLetters = "AzdDd";
        
        assertTrue(validator.validate(validOnlyLetters));
    }
    
    @Test
    public void testValidIdOnlyDigits() {
        String validOnlyDigits = "092";
        
        assertTrue(validator.validate(validOnlyDigits));

    }
    
    @Test
    public void testValidLetterAndDigits() {
        String validMixed = "Az092d";
        
        assertTrue(validator.validate(validMixed));
    }
    
    @Test
    public void testInvalidEmpty() {
        String invalidEmptyString = "";
        
        assertFalse(validator.validate(invalidEmptyString));
    }
    
    @Test
    public void testInvalidContainingSpace() {
        String invalidContainingSpace = "Az092d ";
        
        assertFalse(validator.validate(invalidContainingSpace));
    }
    
    @Test
    public void testInvalidContainingSpecialCharacters() {
        String invalidContainingSpecialCharacters = "*z0%s92d";
        
        assertFalse(validator.validate(invalidContainingSpecialCharacters));
    }

}
