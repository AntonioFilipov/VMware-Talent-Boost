package org.talentboost.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NetworkCardTest {
    private NetworkCard card;
    private static final String VALID_ID = "VNMC";
    private static final String VALID_MAC = "0F-AB-54-4A-43-AC";

    @Test
    public void testValidBasicConstructor() {
        card = new NetworkCard(VALID_ID, VALID_MAC);
        assertEquals(VALID_ID, card.getDeviceId());
        assertEquals(VALID_MAC, card.getMACAddress());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidID() {
        card = new NetworkCard("AD ", VALID_MAC);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMAC() {
        card = new NetworkCard(VALID_ID, "123-123-413-3");
    }
    
}
