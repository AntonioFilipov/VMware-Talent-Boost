package org.talentboost.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;

/**
 * Stop ESX System and save all virtual machine configuration to a file
 * @author Antonio
 *
 */
public class StopESXCommand extends Command {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 0;

    @Override
    public String getCommandName() {
        return "stop";
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

        try {
            if (!validate(args)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS",
                        Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }
        } catch (CommandException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }

        SaveVMCommand saveCommand = new SaveVMCommand();

        for (Entry<String, VirtualMachineRecord> entry : esxRecord.getESXRecord().entrySet()) {
            List<String> keyInList = new ArrayList<String>();
            keyInList.add(entry.getKey());

            saveCommand.execute(keyInList, esxRecord, logger);
        }
        logger.close();
        return;
    }

    @Override
    public String getDescription() {
        return "Stops the ESX and save it state";
    }

}
