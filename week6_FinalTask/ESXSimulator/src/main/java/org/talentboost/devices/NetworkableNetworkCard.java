package org.talentboost.devices;

import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.validators.IPv4Validator;

public class NetworkableNetworkCard extends NetworkCard {
    private String ip;

    public NetworkableNetworkCard(String id, String MACAddress, String ip) {
        super(id, MACAddress);
        this.setIp(ip);
    }
    
    /**
     * @return the IP address of networkable device
     */
    public String getIp() {
        return ip;
    }

    /**
     * Set IP of {@link NetworkCard} instance
     * 
     * @param ip
     *            A character string that represents an IPv4
     * @throws CommandException 
     * @throws IllegalArgumentException
     *             when IP is not valid
     */
    public void setIp(String ip) {
        boolean matches = IPv4Validator.getInstance().validate(ip);

        if (!matches) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS", ip);
            throw new IllegalArgumentException(errorMessage);
        }

        this.ip = ip;
    }
    
//    @Override
//    public String display(){
//        String result = super.display() + " IP:"+this.ip;
//        return result; 
//    }

}
