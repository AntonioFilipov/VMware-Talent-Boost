package org.talentboost.devices;

import static org.junit.Assert.*;

import org.junit.Test;

public class HardDiskTest {

	private HardDisk hd;
	private static final String VALID_ID = "HDD";
	private static final long VALID_SIZE = 132123;
	private static final String VALID_HD_CONTROLLER_ID = "hd1";
	

	@Test
	public void testValidConstructor() {
		hd = new HardDisk(VALID_ID, VALID_SIZE, VALID_HD_CONTROLLER_ID);
		assertEquals(VALID_ID, hd.getDeviceId());
		assertEquals(VALID_SIZE, hd.getSize());
		assertEquals(VALID_HD_CONTROLLER_ID, hd.getParentDeviceId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidID() {
		hd = new HardDisk(VALID_ID, VALID_SIZE, VALID_HD_CONTROLLER_ID);
		hd.setId(" ad");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidControllerID() {
		hd = new HardDisk(VALID_ID, VALID_SIZE, VALID_HD_CONTROLLER_ID);
		hd.setHardDiskControllerID("#d");
	}

}
