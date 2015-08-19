package org.talentboost.devices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;
import org.talentboost.validators.NumberOfArgumentsValidator;

public class NetworkCardFactoryCreator extends DeviceFactory {
    private static final int NETWORKABLE_CARD_ARGUMENTS = 3;
    private static final int NETWORK_CARD_ARGUMENTS = 2;

    final Map<Integer, DeviceFactory> factoryMap = Collections.unmodifiableMap(new HashMap<Integer, DeviceFactory>() {
        {
            put(NETWORK_CARD_ARGUMENTS, new NetworkCardCreator());
            put(NETWORKABLE_CARD_ARGUMENTS, new NetworkableNetworkCardCreator());
        }
    });

    @Override
    public boolean validate(List<String> cmdargs) {
        boolean networkableCardArgumentsResult = NumberOfArgumentsValidator.validate(cmdargs,
                NETWORKABLE_CARD_ARGUMENTS);
        boolean networkCardArgumentsResult = NumberOfArgumentsValidator.validate(cmdargs, NETWORK_CARD_ARGUMENTS);

        if (networkableCardArgumentsResult || networkCardArgumentsResult) {
            return true;
        }

        return false;
    }

    @Override
    public Device createDevice(List<String> params, Logger logger) throws CommandException {
        List<String> devSpecifications = new ArrayList<String>(params);
        int numberOfInputArguments = devSpecifications.size();

        if (!validate(devSpecifications)) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS",
                    Integer.toString(devSpecifications.size()));
            logger.log(errorMessage);
            throw new CommandException(errorMessage);
        }

        if (factoryMap.get(numberOfInputArguments) == null) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT",
                    Integer.toString(devSpecifications.size()));
            logger.log(errorMessage);
            throw new CommandException(errorMessage);
        }

        Device device = factoryMap.get(numberOfInputArguments).createDevice(devSpecifications, logger);

        return device;
    }

    @Override
    public int getNumberOfCommandArguments() {
        // TODO Auto-generated method stub
        return 0;
    }

}
