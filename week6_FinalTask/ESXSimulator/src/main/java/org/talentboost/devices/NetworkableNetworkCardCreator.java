package org.talentboost.devices;

import java.util.ArrayList;
import java.util.List;

import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;
import org.talentboost.validators.NumberOfArgumentsValidator;

public class NetworkableNetworkCardCreator extends DeviceFactory {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 3;

    @Override
    public boolean validate(List<String> cmdargs) {
        boolean result = NumberOfArgumentsValidator.validate(cmdargs, NUMBER_OF_COMMAND_ARGUMENTS);

        return result;
    }

    /**
     * Creates an basic network card
     * 
     * @throws CommandException
     */
    @Override
    public Device createDevice(List<String> params, Logger logger) throws CommandException {
        List<String> devSpecifications = new ArrayList<String>(params);

        if (!validate(devSpecifications)) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS",
                    Integer.toString(devSpecifications.size()));
            logger.log(errorMessage);
            throw new CommandException(errorMessage);
        }

        String devId = devSpecifications.get(0);
        String macAddress = devSpecifications.get(1);
        String devIP = devSpecifications.get(2);

        Device networkableCard = new NetworkableNetworkCard(devId, macAddress, devIP);

        // TODO REFACOR ADD LOGGER
        // System.out.println(networkableCard.display());
        return networkableCard;

    }

    @Override
    public int getNumberOfCommandArguments() {
        return NUMBER_OF_COMMAND_ARGUMENTS;
    }

}
