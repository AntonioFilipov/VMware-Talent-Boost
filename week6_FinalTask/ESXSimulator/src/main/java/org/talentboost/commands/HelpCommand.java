package org.talentboost.commands;

import java.util.Collection;
import java.util.List;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;

/**
 * Lists all commands and short description for each command.
 * 
 * @author Antonio
 *
 */
public class HelpCommand extends Command {
    private static final int NUMBER_OF_COMMAND_ARGUMENTS = 0;

    @Override
    public String getCommandName() {
        // TODO Auto-generated method stub
        return "help";
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
        
        Collection<Command> commands = record.getESX().getCommands();

        String format = "%-10s %-40s\n";
        logger.log(String.format(format, "Name", "Description"));
        for (Command command : commands) {
            logger.log(String.format(format, command.getCommandName(), command.getDescription()));
        }
    }

    @Override
    public String getDescription() {
        return "Lists all commands and short description for each command.";
    }

}
