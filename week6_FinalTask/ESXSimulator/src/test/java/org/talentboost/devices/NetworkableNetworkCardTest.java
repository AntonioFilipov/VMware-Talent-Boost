package org.talentboost.devices;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkableNetworkCardTest {
    private NetworkableNetworkCard card;
    private static final String VALID_ID = "VNMC";
    private static final String VALID_MAC = "0F-AB-54-4A-43-AC";
    private static final String VALID_IP = "192.168.12.46";

    @Test
    public void testValidBasicConstructor() {
        card = new NetworkableNetworkCard(VALID_ID, VALID_MAC, VALID_IP);
        assertEquals(VALID_ID, card.getDeviceId());
        assertEquals(VALID_MAC, card.getMACAddress());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidID() {
        card = new NetworkableNetworkCard("AD ", VALID_MAC, VALID_IP);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMAC() {
        card = new NetworkableNetworkCard(VALID_ID, "123-123-413-3", VALID_IP);
    }

}
