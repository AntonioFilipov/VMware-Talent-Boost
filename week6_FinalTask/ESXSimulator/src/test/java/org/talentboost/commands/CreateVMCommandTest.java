package org.talentboost.commands;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.devices.Device;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachine;
import org.talentboost.utils.ConsoleLogger;
import org.talentboost.utils.Logger;

public class CreateVMCommandTest {
    private CreateVMCommand command;
    private ESXRecord record;
    private VirtualMachine vm;
    private Logger logger;

    @Before
    public void setUp() throws Exception {
        command = new CreateVMCommand();
        record = new ESXRecord(new ESX());
        logger = ConsoleLogger.getInstance();

    }

    @Test
    public void testValidCommandArgs() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid1 \"My UbutnuVm\" 536870912 2";
        String id = "vmid1";
        String name = "My UbutnuVm";
        long memory = 536870912;
        int numberOfCPU = 2;
       
        command.proceed(commandArgs, record, logger);
        
        assertTrue(record.containsID(id));
        assertEquals(name, record.getVMRecord(id).getVM().getName());
        assertEquals(memory, record.getVMRecord(id).getVM().getMemory());
        assertEquals(numberOfCPU, record.getVMRecord(id).getVM().getNumberOfCPU());

    }
    
    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgs() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid1 \"My UbutnuVm\" 536870912";
       
        command.proceed(commandArgs, record, logger);
    }

    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgsSameID() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid1 \"My UbutnuVm\" 536870912";
        command.proceed(commandArgs, record, logger);
    }

}
