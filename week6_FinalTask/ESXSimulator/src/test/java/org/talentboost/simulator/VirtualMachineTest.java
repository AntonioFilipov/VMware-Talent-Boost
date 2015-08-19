package org.talentboost.simulator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class VirtualMachineTest {
    private static final String VALID_ID = "1";
    private static final String VALID_NAME = "VM";
    private static final long VALID_MEMORY = 10000L;
    private static final int VALID_CPU_NUMBER = 2;
    private VirtualMachine vm;
    
    
    @Before
    public void init() {
        vm = new VirtualMachine(VALID_ID, VALID_NAME, VALID_MEMORY, VALID_CPU_NUMBER);
    }
    
    @Test
    public void testValidId() {
        String validIdOnlyLetters = "AzdDd";
        
        vm.setId(validIdOnlyLetters);
        assertEquals(validIdOnlyLetters, vm.getID());
    }
    
    @Test
    public void testValidName() {
        String valid = "Udd d";
        
        vm.setName(valid);
        assertEquals(valid, vm.getName());
    }
    
    @Test
    public void testValidMemory() {
        long memory = 12312341;
        
        vm.setMemory(memory);
        assertEquals(memory, vm.getMemory());
    }
    
    @Test
    public void testValidCPU() {
        int cpuNumber = 1;
        
        vm.setNumberOfCPU(cpuNumber);
        assertEquals(cpuNumber, vm.getNumberOfCPU());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidId() {
        String invalidId = "";
        
        vm.setId(invalidId);
        assertEquals(invalidId, vm.getID());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidName() {
        String invalidName = "c#";
        
        vm.setName(invalidName);
        assertEquals(invalidName, vm.getName());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInvalidMemory() {
        long invalidMemory = -1;
        
        vm.setMemory(invalidMemory);
        assertEquals(invalidMemory, vm.getMemory());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidCPU() {
        int invalidCPUNumber = 10;
        
        vm.setNumberOfCPU(invalidCPUNumber);
        assertEquals(invalidCPUNumber, vm.getNumberOfCPU());
    }
}
