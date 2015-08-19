package org.talentboost.commands;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.devices.Device;
import org.talentboost.devices.SCSIController;
import org.talentboost.simulator.DeviceRecord;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachine;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ConsoleLogger;
import org.talentboost.utils.Logger;

public class AddDeviceCommandTest {
    private ESXRecord record;
    private VirtualMachine vm;
    private VirtualMachineRecord vmRecord;
    private AddDeviceCommand command;
    private Logger logger;
    
    @Before
    public void setUp() throws Exception {
        command = new AddDeviceCommand();
        record = new ESXRecord(new ESX());
        logger = ConsoleLogger.getInstance();
        
        vm = new VirtualMachine("vmid1", "vm One", 0, 2);
        vmRecord= new VirtualMachineRecord(vm);
        
        record.addRecord(vmRecord);
    }

    @Test
    public void testValidCommandWithTypeVideoCard() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 VIDEO_CARD vd1 1024 1";
        command.proceed(commandAsString, record, logger);
        
        assertTrue(record.getVMRecord("vmid1").containsID("vd1"));
        assertEquals("vd1", record.getVMRecord("vmid1").getRecord("vd1").getDevice().getDeviceId());
    }
    
    @Test
    public void testValidCommandWithTypeBasicNetworkCard() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 NETWORK_CARD nc1 10-13-f2-a1-32-12";
        command.proceed(commandAsString, record, logger);
        
        assertTrue(record.getVMRecord("vmid1").containsID("nc1"));
        assertEquals("nc1", record.getVMRecord("vmid1").getRecord("nc1").getDevice().getDeviceId());

    }
    
    @Test
    public void testValidCommandWithTypeNetworkableNetworkCard() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 NETWORK_CARD nnc1 10-13-f2-a1-32-12 192.168.15.24";
        command.proceed(commandAsString, record, logger);
        
        assertTrue(record.getVMRecord("vmid1").containsID("nnc1"));
        assertEquals("nnc1", record.getVMRecord("vmid1").getRecord("nnc1").getDevice().getDeviceId());
    }
    
    @Test
    public void testValidCommandWithTypeHardDiskControllerIDE() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 HARDDISK_CONTROLLER hdc1 IDE";
        command.proceed(commandAsString, record, logger);
        
        assertTrue(record.getVMRecord("vmid1").containsID("hdc1"));
        assertEquals("hdc1", record.getVMRecord("vmid1").getRecord("hdc1").getDevice().getDeviceId());
    }
    
    @Test
    public void testValidCommandWithTypeHardDiskControllerSDCI() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 HARDDISK_CONTROLLER hdc2 SCSI";
        command.proceed(commandAsString, record, logger);
        
        assertTrue(record.getVMRecord("vmid1").containsID("hdc2"));
        assertEquals("hdc2", record.getVMRecord("vmid1").getRecord("hdc2").getDevice().getDeviceId());
    }
    
    @Test
    public void testValidCommandWithTypeHardDisk() throws CommandException, ClassNotFoundException, ApplicationErrorException {
        String commandAsString = "vmid1 HARDDISK hd1 3000 testHD";
        Device device = new SCSIController("testHD", "IDE");
        DeviceRecord deviceRecord = new DeviceRecord(device);
        record.getVMRecord("vmid1").addRecord(deviceRecord);
        command.proceed(commandAsString, record, logger);
        
        assertTrue(record.getVMRecord("vmid1").containsID("testHD"));
        assertTrue(record.getVMRecord("vmid1").getRecord("testHD").getDevices().containsKey("hd1"));
    }
    
    
    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgsNoSuchId() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid4 NETWORK_CARD nnc1 10-13-f2-a1-32-12 192.168.15.24";
       
        command.proceed(commandAsString, record, logger);
    }

    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgsSameID() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 NETWORK_CARD test 10-13-f2-a1-32-12 192.168.15.24";
        command.proceed(commandAsString, record, logger);
        command.proceed(commandAsString, record, logger);
    }
    
    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandArgsCounnt() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 NETWORK_CARD";
        command.proceed(commandAsString, record, logger);
    }

    @Test(expected = ApplicationErrorException.class)
    public void testInvalidCommandType() throws CommandException, ApplicationErrorException {
        String commandAsString = "vmid1 NET_CARD";
        command.proceed(commandAsString, record, logger);
    }
 
}
