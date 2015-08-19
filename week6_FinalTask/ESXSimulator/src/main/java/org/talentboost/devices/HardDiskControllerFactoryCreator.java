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

public class HardDiskControllerFactoryCreator extends DeviceFactory {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 2;

    final Map<String, DeviceFactory> factoryMap =
            Collections.unmodifiableMap(new HashMap<String, DeviceFactory>() {{
                put("IDE", new IDEControllerCreator());
                put("SCSI", new SCSIControllerCreator());
            }});
    
    @Override
    public boolean validate(List<String> cmdargs) {
        boolean result = NumberOfArgumentsValidator.validate(cmdargs, NUMBER_OF_COMMAND_ARGUMENTS);
        
        return result;
    }
    
	@Override
	public Device createDevice(List<String> params, Logger logger) throws CommandException {
        List<String> devSpecifications = new ArrayList<String>(params);

        if (!validate(devSpecifications)) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS", Integer.toString(devSpecifications.size()));
            logger.log(errorMessage);
            throw new CommandException(errorMessage);
        }
        
        String devID = devSpecifications.get(0);
        String devControllerType = devSpecifications.get(1);
        
        if (factoryMap.get(devControllerType) == null) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT", "");
            logger.log(errorMessage);
            throw new CommandException(errorMessage);
		}
        
        Device hardDiskController = factoryMap.get(devControllerType).createDevice(devSpecifications, logger);
        
        
		return hardDiskController;
	}

	@Override
	public int getNumberOfCommandArguments() {
		return NUMBER_OF_COMMAND_ARGUMENTS;
	}

}
