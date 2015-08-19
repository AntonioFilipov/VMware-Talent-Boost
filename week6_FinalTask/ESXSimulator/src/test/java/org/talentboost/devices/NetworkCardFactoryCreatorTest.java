package org.talentboost.devices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ConsoleLogger;

public class NetworkCardFactoryCreatorTest {
    private static final String VALID_ID = "VNMC";
    private static final String VALID_MAC = "0F-AB-54-4A-43-AC";
    private static final String VALID_IP = "192.168.12.46";
	private NetworkCardFactoryCreator creator;
	private ConsoleLogger logger;

	@Before
	public void setUp() throws Exception {
		creator = new NetworkCardFactoryCreator();
	}

	@Test
	public void testValidCreateNetworkCard() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkCard card;
		devSpecifications.add(VALID_ID);
		devSpecifications.add(VALID_MAC);
		
		card = new NetworkCard(VALID_ID, VALID_MAC);

		card = (NetworkCard) creator.createDevice(devSpecifications, logger);

		assertEquals(VALID_ID, card.getDeviceId());
		assertEquals(VALID_MAC, card.getMACAddress());
	}

	@Test
	public void testValidCreateNetworkableNetworkCard() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkableNetworkCard card;
		devSpecifications.add(VALID_ID);
		devSpecifications.add(VALID_MAC);
		devSpecifications.add(VALID_IP);


		card = (NetworkableNetworkCard) creator.createDevice(devSpecifications, logger);

		assertEquals(VALID_ID, card.getDeviceId());
		assertEquals(VALID_MAC, card.getMACAddress());
		assertEquals(VALID_IP, card.getIp());
	}

	@Test(expected = CommandException.class)
	public void testInvalidArgumentsCount() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkableNetworkCard card;
		devSpecifications.add(VALID_ID);
		card = (NetworkableNetworkCard) creator.createDevice(devSpecifications, logger);
	}

	@Test(expected = CommandException.class)
	public void testInvalidType() throws CommandException {
		List<String> devSpecifications = new ArrayList<String>();
		NetworkableNetworkCard card;
		devSpecifications.add(VALID_ID);
		devSpecifications.add(VALID_MAC);
		devSpecifications.add(VALID_IP);
		devSpecifications.add(VALID_IP);
		card = (NetworkableNetworkCard) creator.createDevice(devSpecifications, logger);
	}

}
