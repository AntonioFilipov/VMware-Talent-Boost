package org.talentboost.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.commands.AddDeviceCommand;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachine;
import org.talentboost.simulator.VirtualMachineRecord;

public class HardDiskControllerTest {
	private HardDiskController controller;
	private static final String VALID_ID = "HDD";
	private static final String VALID_TYPE = "IDE";
	
	@Before
    public void setUp() throws Exception {
		controller = new IDEController(VALID_ID, VALID_TYPE);
    }
	
	@Test
	public void testValidID() {
		controller.setId("ADS");
		assertEquals("ADS", controller.getDeviceId());
	}
	
	@Test
	public void testValidType() {
		controller.setType("SCSI");
		assertEquals(HardDiskControllerTypes.SCSI, controller.getType());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidType() {
		controller.setType("ada");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidID() {
		controller.setId("AD S");
	}

}
