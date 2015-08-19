package org.talentboost.commands;

import java.util.List;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;

/**
 * Deletes a virtual machine from ESX system
 * 
 * @author Antonio
 *
 */
public class DeleteVMCommand extends Command {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 1;

    @Override
    public String getCommandName() {
        return "delete-vm";
    }

    @Override
    public boolean validate(List<String> cmdargs) {
        List<String> args = cmdargs;
        int numberOfInputArguments = args.size();

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

            if (!record.containsID(vmID)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_NO_SUCH_ID", Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }

            record.deleteESXRecord(vmID);
        } catch (CommandException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Deletes a virtual machine from ESX system";
    }
}
