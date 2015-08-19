package org.talentboost.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.simulator.VirtualMachineRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;

/**
 * Read virtual machine configuration from file and stores it in given ESXRecord.
 * Uses deserialization.
 * @author Antonio
 *
 */
public class ReadVMCommand extends Command {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 1;

    @Override
    public String getCommandName() {
        return "read-vm";
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
    public void execute(List<String> cmdargs, ESXRecord esxRecord, Logger logger) throws CommandException, ApplicationErrorException {
        List<String> args = new ArrayList<String>(cmdargs);

        try{
            if (!validate(args)) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_NUMBER_OF_ARGUMENTS", Integer.toString(args.size()));
                throw new CommandException(errorMessage);
            }
        } catch (CommandException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }

        String vmID = args.get(0);
 
        VirtualMachineRecord record = null;

        try {
            File file = new File("vms\\vm_vmid"+vmID+".ser");
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            record = (VirtualMachineRecord) in.readObject();
            esxRecord.addRecord(record);
            in.close();
            fileIn.close();
        }catch(FileNotFoundException e){
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }catch (IOException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.log(e.toString());
            throw new ApplicationErrorException(e.getMessage());
        }

    }

    @Override
    public String getDescription() {
        String description = "Saves virtual machine with specified id to file";

        return description;
    }

}
