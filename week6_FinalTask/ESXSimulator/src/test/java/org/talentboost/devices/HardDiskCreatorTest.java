package org.talentboost.devices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ConsoleLogger;

public class HardDiskCreatorTest {
	private HardDiskCreator creator;
	private ConsoleLogger logger;
	@Before
	public void setUp() throws Exception {
		creator = new HardDiskCreator();
	}

	@Test
	public void testValidCreateDevice() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		HardDisk disk;
		devSpecifications.add("id1");
		devSpecifications.add("1000");
		devSpecifications.add("controllerID");

		disk = (HardDisk) creator.createDevice(devSpecifications, logger);

		assertEquals("id1", disk.getDeviceId());
		assertEquals(1000, disk.getSize());
		assertEquals("controllerID", disk.getParentDeviceId());
	}

	@Test(expected = CommandException.class)
	public void testInvalidArgumentsCount() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		HardDisk disk;
		devSpecifications.add("id1");
		disk = (HardDisk) creator.createDevice(devSpecifications, logger);
	}

}
