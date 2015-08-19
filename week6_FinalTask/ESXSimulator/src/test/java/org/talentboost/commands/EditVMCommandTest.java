package org.talentboost.commands;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.devices.Device;
import org.talentboost.devices.VideoCard;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachine;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ConsoleLogger;
import org.talentboost.utils.Logger;
import org.talentboost.commands.EditVMCommand;

public class EditVMCommandTest {
    private EditVMCommand command;
    private ESXRecord record;
    private Logger logger;

    
    @Before
    public void setUp() throws Exception {
        command = new EditVMCommand();
        record = new ESXRecord(new ESX());
        logger = ConsoleLogger.getInstance();

        
        VirtualMachine vmOne = new VirtualMachine("vmid1", "vm One", 0, 0);
        VirtualMachine vmTwo = new VirtualMachine("vmid2", "vm Two", 2, 2);
        
        VirtualMachineRecord vmRecordOne = new VirtualMachineRecord(vmOne);
        VirtualMachineRecord vmRecordTwo = new VirtualMachineRecord(vmTwo);
        
        record.addRecord(vmRecordOne);
        record.addRecord(vmRecordTwo);
    }

    @Test
    public void testValidEdit() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid1 \'New name\' 536870912 1";
        String id = "vmid1";
        String name = "New name";
        long memory =  536870912;
        int numberOfCPU = 1;
        
        command.proceed(commandArgs, record, logger);
        
        assertTrue(record.containsID(id));
        
        assertEquals(name, record.getVMRecord(id).getVM().getName());
        assertEquals(memory, record.getVMRecord(id).getVM().getMemory());
        assertEquals(numberOfCPU, record.getVMRecord(id).getVM().getNumberOfCPU());
    }
    
    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgs() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid1 \'New name\' 536870912";
       
        command.proceed(commandArgs, record, logger);
    }

    @Test(expected = ApplicationErrorException.class)
    public void testInvalidDeleteCommandNotFoundID() throws CommandException, ApplicationErrorException {
        String commandArgs = "vmid3";
        command.proceed(commandArgs, record, logger);
    }
}
