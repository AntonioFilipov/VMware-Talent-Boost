package org.talentboost.devices;

import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.validators.AlphanumericCharacterValidator;
import org.talentboost.validators.IPv4Validator;
import org.talentboost.validators.MAC48Validator;
import org.talentboost.validators.MAC48ValidatorTest;

/**
 * Represents a network card device. Every network card should have an id and
 * MAC address.
 * 
 * @author Antonio
 *
 */
public class NetworkCard extends Device {
    private String id = "";
    private String MACAddress = "";

    /**
     * Basic constructor for creating an instance of {@link NetworkCard}
     * 
     * @param id
     *            A character string that is unique through all devices for the
     *            VM. May only contain alphanumeric characters.
     * @param MACAddress
     *            The format is “HH-HH-HH-HH-HH-HH”, where “H” is a hexadecimal
     *            digit
     */
    public NetworkCard(String id, String MACAddress) {
        this.setId(id);
        this.setMACAddress(MACAddress);
    }

    /**
     * Set id of {@link NetworkCard} instance
     * 
     * @param id
     *            A character string. May only contain alphanumeric characters.
     * @throws IllegalArgumentException
     *             when id is not valid
     */
    public void setId(String id) {
        boolean matches = AlphanumericCharacterValidator.getInstance().validate(id);

        if (!matches) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT", "");
            throw new IllegalArgumentException(errorMessage);
        }
        this.id = id;
    }

    /**
     * @return the MAC address of {@link NetworkCard} instance
     */
    public String getMACAddress() {
        return MACAddress;
    }

    /**
     * Set MAC of {@link NetworkCard} instance
     * 
     * @param macAddress
     *            A character string. The format is “HH-HH-HH-HH-HH-HH”, where
     *            “H” is a hexadecimal digit
     * @throws IllegalArgumentException
     *             when MAC is not valid
     */
    public void setMACAddress(String macAddress) {
        boolean matches = MAC48Validator.getInstance().validate(macAddress);

        if (!matches) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT", "");
            throw new IllegalArgumentException(errorMessage);
        }

        this.MACAddress = macAddress;
    }

    /**
     * @return the ID of {@link NetworkCard} instance
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
        return DeviceTypes.NETWORK_CARD;
    }

    // @Override
    // public String display(){
    // String result = "ID: "+this.id + "  MacAddress: "+this.MACAddress;
    // return result;
    // }
}
