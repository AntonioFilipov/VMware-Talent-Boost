package org.talentboost.devices;

import org.talentboost.validators.AlphanumericCharacterValidator;

/**
 * Represents a video card device. Every network card should have an id,
 * videoRAM and number of displays MAC address.
 * 
 * @author Antonio
 *
 */
public class VideoCard extends Device {
    private static final int MAX_RAM_IN_KB = 4_000_000;
    private static final int MIN_RAM_IN_KB = 0;
    private static final int MAX_DISPLAY_NUMBER = 2;
    private static final int MIN_DISPLAY_NUMBER = 0;
    private String id = "";
    private long RAM = 0L;
    private int displayNumber = 0;

    /**
     * Basic constructor for creating an instance of {@link VideoCard}
     * 
     * @param id
     *            A character string that is unique through all devices for the
     *            VM. May only contain alphanumeric characters.
     * @param RAM
     *            Numeric type. Measured in KB.
     * @param displayNumber
     *            Numeric type.
     */
    public VideoCard(String id, long RAM, int displayNumber) {
        this.setId(id);
        this.setRAM(RAM);
        this.setDisplayNumber(displayNumber);
    }

    /**
     * Set id of {@link VideoCard} instance
     * 
     * @param id
     *            A character string. May only contain alphanumeric characters.
     * @throws IllegalArgumentException
     *             when id is not valid
     */
    public void setId(String id) {
        boolean matches = AlphanumericCharacterValidator.getInstance().validate(id);

        if (!matches) {
            throw new IllegalArgumentException("Invalid id!");
        }
        this.id = id;
    }

    /**
     * @return the video RAM of {@link VideoCard} instance
     */
    public long getRAM() {
        return this.RAM;
    }

    /**
     * Set RAM of {@link VideoCard} instance
     * 
     * @param RAM
     *            Numeric type. Measured in KB.
     * @throws IllegalArgumentException
     *             when RAM is great than {@value MAX_RAM_IN_KB} or less than
     *             {@value MIN_RAM_IN_KB}
     */
    public void setRAM(long RAM) {
        if (RAM > MAX_RAM_IN_KB) {
            throw new IllegalArgumentException("Memorry cannot be great than " + MAX_RAM_IN_KB);
        } else if (RAM < MIN_RAM_IN_KB) {
            throw new IllegalArgumentException("Memorry cannot be less than " + MIN_RAM_IN_KB);
        }
        this.RAM = RAM;
    }

    /**
     * Return the number of displays of {@link VideoCard} instance
     * 
     * @return A character string
     */
    public int getDisplayNumber() {
        return this.displayNumber;
    }

    /**
     * Set display number of {@link VideoCard} instance
     * 
     * @param displayNumber
     *            Numeric type.
     * @throws IllegalArgumentException
     *             when number of displays is great than {@value MAX_DISPLAY_NUMBER} or less than
     *             {@value MIN_DISPLAY_NUMBER}
     */
    public void setDisplayNumber(int displayNumber) {
        if (displayNumber < MIN_DISPLAY_NUMBER) {
            throw new IllegalArgumentException("Number of displays cannot be less than " + MIN_DISPLAY_NUMBER);
        } else if (displayNumber > MAX_DISPLAY_NUMBER) {
            throw new IllegalArgumentException("Number of displays cannot be great than " + MAX_DISPLAY_NUMBER);
        }
        this.displayNumber = displayNumber;
    }

    /**
     * @return the ID of {@link VideoCard} instance
     */
    @Override
    public String getDeviceId() {
        return this.id;
    }

    /**
     * @return the device type 
     */
    @Override
    public DeviceTypes getDeviceType() {
        return DeviceTypes.VIDEO_CARD;
    }

    public int getMaxRAM(){
        return this.MAX_RAM_IN_KB;
    }
    
    public int getMinRAM(){
        return this.MIN_RAM_IN_KB;
    }
    
    public int getMaxDisplayNumber(){
        return this.MAX_DISPLAY_NUMBER;
    }
    
    public int getMinDisplayNumber(){
        return this.MIN_DISPLAY_NUMBER;
    }
    @Override
    public String toString() {
        return "ID:"+this.id+ " RAM:"+this.RAM + " Display number:"+this.displayNumber;
    }

}
