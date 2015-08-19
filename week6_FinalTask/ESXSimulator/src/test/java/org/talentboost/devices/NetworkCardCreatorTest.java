package org.talentboost.devices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ConsoleLogger;

public class NetworkCardCreatorTest {
	private NetworkCardCreator creator;
	private ConsoleLogger logger;
	@Before
	public void setUp() throws Exception {
		creator = new NetworkCardCreator();
	}

	@Test
	public void testValidCreateDevice() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkCard card;
		devSpecifications.add("id1");
		devSpecifications.add("12-12-12-12-12-12");

		card = (NetworkCard) creator.createDevice(devSpecifications, logger);

		assertEquals("id1", card.getDeviceId());
		assertEquals("12-12-12-12-12-12", card.getMACAddress());
	}

	@Test(expected = CommandException.class)
	public void testInvalidArgumentsCount() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkCard card;
		devSpecifications.add("id1");
		card = (NetworkCard) creator.createDevice(devSpecifications, logger);
	}
}
