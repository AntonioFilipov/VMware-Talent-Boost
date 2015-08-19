package org.talentboost.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MAC48ValidatorTest {

    private MAC48Validator validator;
    
    @Before
    public void setUp() throws Exception {
        validator = MAC48Validator.getInstance();
    }

    @Test
    public void testValidMAC() {
        String MAC = "13-F3-A3-43-23-B2";
        
        assertTrue(MAC, validator.validate(MAC));
    }
    
    @Test
    public void testValidMACLowerCase() {
        String MAC = "13-f3-a3-43-23-B2";
        
        assertTrue(MAC, validator.validate(MAC));
    }

    @Test
    public void testInvalidMACSeparator() {
        String MAC = "13:F3:A3:43:23:B2";
        
        assertFalse(MAC, validator.validate(MAC));
    }
    
    @Test
    public void testInvalidMACOctetCount() {
        String MAC = "13-F3-A3-43-23";
        
        assertFalse(MAC, validator.validate(MAC));
    }
    
    @Test
    public void testInvalidMACOctetLetter() {
        String MAC = "13-F3-G3-43-23";
        
        assertFalse(MAC, validator.validate(MAC));
    }
    
    @Test
    public void testInvalidMACOctet() {
        String MAC = "133-F3-G3-43-23";
        
        assertFalse(MAC, validator.validate(MAC));
    }
}
