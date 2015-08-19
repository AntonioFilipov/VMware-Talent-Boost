package org.talentboost.devices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ConsoleLogger;
import org.talentboost.utils.Logger;

public class HardDiskControllerFactoryCreatorTest {
	private HardDiskControllerFactoryCreator creator;
	private ConsoleLogger logger;
	
	@Before
    public void setUp() throws Exception {
		creator = new HardDiskControllerFactoryCreator();
    }
	
	@Test
	public void testValidCreateIDEDevice() throws CommandException {
		 List<String> devSpecifications = new ArrayList<String>();
		 IDEController ide;
		 devSpecifications.add("id1");
		 devSpecifications.add("IDE");
		 
		 ide = (IDEController) creator.createDevice(devSpecifications, logger);
		 
		 assertEquals("id1", ide.getDeviceId());
		 assertEquals(HardDiskControllerTypes.IDE, ide.getType());
	}
	
	@Test
	public void testValidCreateSCSIDevice() throws CommandException {
		 List<String> devSpecifications = new ArrayList<String>();
		 SCSIController ide;
		 devSpecifications.add("id1");
		 devSpecifications.add("SCSI");
		 
		 ide = (SCSIController) creator.createDevice(devSpecifications, logger);
		 
		 assertEquals("id1", ide.getDeviceId());
		 assertEquals(HardDiskControllerTypes.SCSI, ide.getType());
	}
	
	@Test(expected = CommandException.class)
	public void testInvalidArgumentsCount() throws CommandException {
		 List<String> devSpecifications = new ArrayList<String>();
		 SCSIController ide;
		 devSpecifications.add("id1");
		 SCSIController scsi = (SCSIController) creator.createDevice(devSpecifications, logger);
	}
	
	@Test(expected = CommandException.class)
	public void testInvalidType() throws CommandException {
		 List<String> devSpecifications = new ArrayList<String>();
		 SCSIController ide;
		 devSpecifications.add("id1");
		 devSpecifications.add("idei");
		 SCSIController scsi = (SCSIController) creator.createDevice(devSpecifications, logger);
	}
	
	
	

}
