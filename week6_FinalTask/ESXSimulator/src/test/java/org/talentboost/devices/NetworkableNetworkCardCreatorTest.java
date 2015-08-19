package org.talentboost.devices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ConsoleLogger;

public class NetworkableNetworkCardCreatorTest {

	private NetworkableNetworkCardCreator creator;
	private ConsoleLogger logger;
	
	@Before
	public void setUp() throws Exception {
		creator = new NetworkableNetworkCardCreator();
	}

	@Test
	public void testValidCreateDevice() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkableNetworkCard card;
		devSpecifications.add("id1");
		devSpecifications.add("12-12-12-12-12-12");
		devSpecifications.add("192.168.12.45");


		card = (NetworkableNetworkCard) creator.createDevice(devSpecifications, logger);

		assertEquals("id1", card.getDeviceId());
		assertEquals("12-12-12-12-12-12", card.getMACAddress());
		assertEquals("192.168.12.45", card.getIp());

	}

	@Test(expected = CommandException.class)
	public void testInvalidArgumentsCount() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkableNetworkCard card;
		devSpecifications.add("id1");
		card = (NetworkableNetworkCard) creator.createDevice(devSpecifications, logger);
	}

}
