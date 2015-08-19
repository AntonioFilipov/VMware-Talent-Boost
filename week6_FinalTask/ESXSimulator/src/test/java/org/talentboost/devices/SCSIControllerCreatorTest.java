package org.talentboost.devices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ConsoleLogger;

public class SCSIControllerCreatorTest {

	private SCSIControllerCreator creator;
	private ConsoleLogger logger;
	@Before
	public void setUp() throws Exception {
		creator = new SCSIControllerCreator();
	}

	@Test
	public void testValidCreateDevice() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		SCSIController controller;
		devSpecifications.add("id1");
		devSpecifications.add("SCSI");

		controller = (SCSIController) creator.createDevice(devSpecifications, logger);

		assertEquals("id1", controller.getDeviceId());
		assertEquals(HardDiskControllerTypes.SCSI, controller.getType());
	}

	@Test(expected = CommandException.class)
	public void testInvalidArgumentsCount() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		HardDisk disk;
		devSpecifications.add("id1");
		disk = (HardDisk) creator.createDevice(devSpecifications, logger);
	}

}
