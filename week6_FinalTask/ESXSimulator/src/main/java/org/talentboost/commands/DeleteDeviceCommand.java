package org.talentboost.commands;

import java.util.Collection;
import java.util.List;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.devices.Device;
import org.talentboost.devices.DeviceComponent;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;

/**
 * Delete device from virtual machine
 * 
 * @author Antonio
 *
 */
public class DeleteDeviceCommand extends Command {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 2;

    @Override
    public String getCommandName() {
        return "delete-dev";
    }

    @Override
    public boolean validate(List<String> cmdargs) {
        int numberOfInputArguments = cmdargs.size();

        if (numberOfInputArguments != NUMBER_OF_COMMAND_ARGUMENTS) {
            return false;
        }

        return true;
    }

    @Override
    public void execute(List<String> cmdargs, ESXRecord record, Logger logger) throws CommandException,
            ApplicationErrorException {
        List<String> args = cmdargs;

        try {
            if (!validate(args)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS",
                        Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }

            String vmID = args.get(0);
            String devID = args.get(1);

            if (!record.containsID(vmID)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_NO_SUCH_ID", Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }

            if (!record.getVMRecord(vmID).containsID(devID)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_NO_SUCH_ID", Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }

            record.getVMRecord(vmID).deleteDeviceRecord(devID);
        } catch (CommandException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Delete device from virtual machine";
    }

}
