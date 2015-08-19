package org.talentboost.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.validators.IPv4Validator;

public class VideoCardTest {
    private VideoCard card;
    private static final String VALID_ID = "VVC";
    private static final long VALID_RAM = 132123;
    private static final int VALID_DISPLAY_NUMBER = 1;

    @Test
    public void testValidConstructor() {
        card = new VideoCard(VideoCardTest.VALID_ID, VideoCardTest.VALID_RAM, VideoCardTest.VALID_DISPLAY_NUMBER);
        assertEquals(VideoCardTest.VALID_ID, card.getDeviceId());
        assertEquals(VideoCardTest.VALID_RAM, card.getRAM());
        assertEquals(VideoCardTest.VALID_DISPLAY_NUMBER, card.getDisplayNumber());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidID() {
        card = new VideoCard(VideoCardTest.VALID_ID, VideoCardTest.VALID_RAM, VideoCardTest.VALID_DISPLAY_NUMBER);
        card.setId(" ad");
        System.out.println(card.getMaxRAM());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRAMOverMaxRam() {
        card = new VideoCard(VideoCardTest.VALID_ID, VideoCardTest.VALID_RAM, VideoCardTest.VALID_DISPLAY_NUMBER);
        int ram = card.getMaxRAM();
        card.setRAM(ram+1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRAMLessThanMinRam() {
        card = new VideoCard(VideoCardTest.VALID_ID, VideoCardTest.VALID_RAM, VideoCardTest.VALID_DISPLAY_NUMBER);
        int ram = card.getMinRAM();
        card.setRAM(ram-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDisplayNumberLessThanMinDisplayCount() {
        card = new VideoCard(VideoCardTest.VALID_ID, VideoCardTest.VALID_RAM, VideoCardTest.VALID_DISPLAY_NUMBER);
        int displayNumber = card.getMinDisplayNumber();
        card.setDisplayNumber(displayNumber-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDisplayNumberGreatThanMaxDisplayCount() {
        card = new VideoCard(VideoCardTest.VALID_ID, VideoCardTest.VALID_RAM, VideoCardTest.VALID_DISPLAY_NUMBER);
        int displayNumber = card.getMaxDisplayNumber();
        card.setDisplayNumber(displayNumber+1);
    }
    

}
