package org.talentboost.commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachine;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ConsoleLogger;
import org.talentboost.utils.Logger;

public class DeleteVMCommandTest {
    private DeleteVMCommand command;
    private ESXRecord record;
    private Logger logger;

    
    @Before
    public void setUp() throws Exception {
        command = new DeleteVMCommand();
        record = new ESXRecord(new ESX());
        logger = ConsoleLogger.getInstance();

        
        VirtualMachine vmOne = new VirtualMachine("vmid1", "vm One", 0, 2);
        VirtualMachine vmTwo = new VirtualMachine("vmid2", "vm Two", 2, 2);
        
        VirtualMachineRecord vmRecordOne = new VirtualMachineRecord(vmOne);
        VirtualMachineRecord vmRecordTwo = new VirtualMachineRecord(vmTwo);
        
        record.addRecord(vmRecordOne);
        record.addRecord(vmRecordTwo);
    }

    @Test
    public void testValidDeleteCommand() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid1";

        assertTrue(record.containsID("vmid1"));
        assertTrue(record.containsID("vmid2"));

        command.proceed(commandArgs, record, logger);
        assertFalse(record.containsID("vmid1"));
        assertTrue(record.containsID("vmid2"));
    }
    
    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgs() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid1 ew";
       
        command.proceed(commandArgs, record, logger);
    }

    @Test(expected = ApplicationErrorException.class)
    public void testInvalidDeleteCommandNotFoundID() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid3";
        command.proceed(commandArgs, record, logger);
    }
}
