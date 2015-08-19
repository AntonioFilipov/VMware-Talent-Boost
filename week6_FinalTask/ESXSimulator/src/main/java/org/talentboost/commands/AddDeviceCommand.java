package org.talentboost.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.devices.Device;
import org.talentboost.devices.DeviceFactory;
import org.talentboost.devices.HardDiskControllerFactoryCreator;
import org.talentboost.devices.HardDiskCreator;
import org.talentboost.devices.DeviceComponent;
import org.talentboost.devices.NetworkCardFactoryCreator;
import org.talentboost.devices.VideoCardCreator;
import org.talentboost.simulator.DeviceRecord;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;
import org.talentboost.utils.Splitter;

/**
 * Add device or component of device to the virtual machine with given ID.
 * 
 * @author Antonio
 *
 */
public class AddDeviceCommand extends Command {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 3;

    @Override
    public String getCommandName() {
        return "add-dev";
    }

    @Override
    public boolean validate(List<String> cmdargs) {
        int numberOfInputArguments = cmdargs.size();

        if (numberOfInputArguments < NUMBER_OF_COMMAND_ARGUMENTS) {
            return false;
        }

        return true;
    }

    @Override
    public void execute(List<String> cmdargs, ESXRecord esxRecord, Logger logger) throws CommandException,
            ApplicationErrorException {
        List<String> args = new ArrayList<String>(cmdargs);

        final Map<String, DeviceFactory> factoryMap = Collections.unmodifiableMap(new HashMap<String, DeviceFactory>() {
            {
                put("NETWORK_CARD", new NetworkCardFactoryCreator());
                put("VIDEO_CARD", new VideoCardCreator());
                put("HARDDISK_CONTROLLER", new HardDiskControllerFactoryCreator());
                put("HARDDISK", new HardDiskCreator());
            }
        });

        try {
            if (!validate(args)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS",
                        Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }

            String vmID = args.get(0);
            String devType = args.get(1);

            String devSpec = Splitter.getStringRepresentation(args, NUMBER_OF_COMMAND_ARGUMENTS - 1, args.size());

            DeviceFactory factory = factoryMap.get(devType);
            if (factory == null) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_DEVICE_TYPE", "");
                throw new CommandException(errorMessage);
            }

            try {
                Device device = factory.run(devSpec, logger);
                String deviceId = device.getDeviceId();

                if (!esxRecord.containsID(vmID)) {
                    String errorMessage = ErrorBundle.getErrorMessage("ERR_NO_SUCH_ID", vmID);
                    throw new CommandException(errorMessage);
                }

                if (esxRecord.getVMRecord(vmID).containsID(deviceId)) {
                    String errorMessage = ErrorBundle.getErrorMessage("ERR_CANNOT_PUT_SAME_ID", vmID);
                    throw new CommandException(errorMessage);
                }

                DeviceRecord devRecord = new DeviceRecord(device);

                //check if device is component
                //if it is, then add component to device with given id 
                if (device instanceof DeviceComponent) {
                    DeviceComponent devComponent = (DeviceComponent) device;
                    String parentID = devComponent.getParentDeviceId();
                    try {
                        esxRecord.getVMRecord(vmID).getDeviceRecord().get(parentID).addRecord(devComponent);
                    } catch (ClassNotFoundException e) {

                    }
                } else {
                    try {
                        esxRecord.getVMRecord(vmID).addRecord(devRecord);
                    } catch (ClassNotFoundException e) {
                        logger.log(e.toString());
                        throw new ApplicationErrorException(e.getMessage());
                    }
                }

            } catch (IllegalArgumentException e) {
                logger.log(e.toString());
                throw new ApplicationErrorException(e.getMessage());
            } catch (CommandException e) {
                logger.log(e.toString());
                throw new ApplicationErrorException(e.getMessage());
            }

        } catch (CommandException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }

    }

    @Override
    public String getDescription() {
        return "Add device to a virtual machine";
    }
}
