package org.talentboost.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IPv4ValidatorTest {
    private IPv4Validator validator;
    
    @Before
    public void setUp() throws Exception {
        validator = IPv4Validator.getInstance();
    }
    
    @Test
    public void testValidIP() {
        String IP = "192.168.12.129";
        
        assertTrue(validator.validate(IP));
    }
    
    @Test
    public void testInvalidIPSeparator() {
        String IP = "192:168:12:129";
        
        assertFalse(validator.validate(IP));
    }
    
    @Test
    public void testInvalidIPOctets() {
        String IP = "192.129.13";
        
        assertFalse(validator.validate(IP));
    }
    
    @Test
    public void testInvalidIPOver255() {
        String IP = "192.256.13.3";
        
        assertFalse(validator.validate(IP));
    }

}
