package org.talentboost.devices;

import java.util.ArrayList;
import java.util.List;

import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;
import org.talentboost.validators.NumberOfArgumentsValidator;

public class SCSIControllerCreator extends DeviceFactory {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 2;

    @Override
    public boolean validate(List<String> cmdargs) {
        boolean result = NumberOfArgumentsValidator.validate(cmdargs, NUMBER_OF_COMMAND_ARGUMENTS);

        return result;
    }

    @Override
    public Device createDevice(List<String> params, Logger logger) throws CommandException {
        List<String> devSpecifications = new ArrayList<String>(params);

        if (!validate(devSpecifications)) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT",
                    Integer.toString(devSpecifications.size()));
            logger.log(errorMessage);
            throw new CommandException(errorMessage);
        }

        String devID = devSpecifications.get(0);
        String devType = devSpecifications.get(1);

        Device scsiController = new SCSIController(devID, devType);

        return scsiController;
    }

    @Override
    public int getNumberOfCommandArguments() {
        return NUMBER_OF_COMMAND_ARGUMENTS;
    }

}
