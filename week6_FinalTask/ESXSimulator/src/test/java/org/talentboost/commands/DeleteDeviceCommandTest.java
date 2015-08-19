package org.talentboost.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.devices.Device;
import org.talentboost.devices.SCSIController;
import org.talentboost.devices.VideoCard;
import org.talentboost.simulator.DeviceRecord;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachine;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ConsoleLogger;
import org.talentboost.utils.Logger;

public class DeleteDeviceCommandTest {

    private ESXRecord record;
    private VirtualMachine vm;
    private VirtualMachineRecord vmRecord;
    private DeleteDeviceCommand command;
    private Logger logger;

    
    @Before
    public void setUp() throws Exception {
        command = new DeleteDeviceCommand();
        record = new ESXRecord(new ESX());
        logger = ConsoleLogger.getInstance();

        vm = new VirtualMachine("vmid1", "vm One", 0, 2);
        vmRecord= new VirtualMachineRecord(vm);
        
        record.addRecord(vmRecord);
    }

    @Test
    public void testValidDeleteDeviceCommand() throws CommandException, ClassNotFoundException, ApplicationErrorException {
        String commandAsString = "vmid1 test";
        
        Device device = new SCSIController("test", "IDE");
        DeviceRecord deviceRecord = new DeviceRecord(device);
        record.getVMRecord("vmid1").addRecord(deviceRecord);
        
        assertTrue(record.getVMRecord("vmid1").containsID("test"));

        command.proceed(commandAsString, record, logger);
        
        assertFalse(record.getVMRecord("vmid1").containsID("test"));
    }
    
    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgsNoSuchVMId() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid4 test";
       
        command.proceed(commandAsString, record, logger);
    }

    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgsNoSuchDeviceID() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 noSuchId";
        command.proceed(commandAsString, record, logger);
    }
    
    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgsCount() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1";
        command.proceed(commandAsString, record, logger);
    }
    
}
