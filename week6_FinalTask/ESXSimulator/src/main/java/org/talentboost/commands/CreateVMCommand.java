package org.talentboost.commands;

import java.util.ArrayList;
import java.util.List;

import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachine;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;
import org.talentboost.utils.QuoteRemover;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;

/**
 * Creates a virtual machine in ESX system
 * 
 * @author Antonio
 *
 */
public class CreateVMCommand extends Command {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 4;

    @Override
    public String getCommandName() {
        return "create-vm";
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
    public void execute(List<String> cmdargs, ESXRecord esxRecord, Logger logger) throws ApplicationErrorException {
        List<String> args = new ArrayList<String>(cmdargs);
        try {
            if (!validate(args)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS",
                        Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }

            String vmID = args.get(0);
            String vmName = QuoteRemover.remove(args.get(1));
            long vmMemory = Long.parseLong(args.get(2));
            int vmNumberOfCPU = Integer.parseInt(args.get(3));

            if (esxRecord.containsID(vmID)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_CANNOT_PUT_SAME_ID", vmID);
                logger.log(errorMessage);
                throw new CommandException(errorMessage);
            }

            try {
                VirtualMachine vm = new VirtualMachine(vmID, vmName, vmMemory, vmNumberOfCPU);

                VirtualMachineRecord vmRecord = new VirtualMachineRecord(vm);
                esxRecord.addRecord(vmRecord);
            } catch (IllegalArgumentException e) {
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
        return "Creates a virtual machine in ESX system";
    }

}
