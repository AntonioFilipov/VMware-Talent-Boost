package org.talentboost.commands;

import java.util.List;
import java.util.Map.Entry;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;

/**
 * Displays all virtual machines in ESX system
 * @author Antonio
 *
 */
public class DisplayVMCommand extends Command{
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 0;

    @Override
    public String getCommandName() {
        return "print-vms";
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
    public void execute(List<String> cmdargs, ESXRecord record, Logger logger) throws CommandException, ApplicationErrorException {
        List<String> args = cmdargs;
        
        try{
            if (!validate(args)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS", Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }
        } catch (CommandException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }
        
        String format = "%-10s %-20s %-20s %-20s\n";
        logger.log(String.format(format, "ID", "Name", "Memmory", "CPU" ));
        for (Entry<String, VirtualMachineRecord> entry : record.getESXRecord().entrySet()){
            logger.log(entry.getValue().getVM().toString());
        }
    }

    @Override
    public String getDescription() {
        return "Displays all virtual machines in ESX system";
    }
}