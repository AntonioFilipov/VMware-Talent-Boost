package org.talentboost.commands;

import java.util.List;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.utils.Logger;
import org.talentboost.utils.Splitter;

/**
 * Basic class for all commands. Command, template and facade patterns are used
 * 
 * @author Antonio
 *
 */
public abstract class Command {
    public abstract String getCommandName();

    /**
     * return description of the command
     * 
     * @return
     */
    public abstract String getDescription();

    /**
     * validate number of input arguments
     * 
     * @param cmdargs
     *            list of command arguments
     */
    public abstract boolean validate(List<String> cmdargs);

    /**
     * Execute command
     * 
     * @param cmdargs
     *            list of command arguments
     * @param esxRecord
     *            given record in which operations are executed
     * @param logger
     *            log errors and information of the exceptions
     * @throws CommandException
     * 
     * @throws ApplicationErrorException
     */
    public abstract void execute(List<String> cmdargs, ESXRecord esxRecord, Logger logger) throws CommandException,
            ApplicationErrorException;

    /**
     * method for creating list of commands from input string
     * 
     * @param cmdargs
     *            string representing command arguments
     * @return list of strings
     */
    public List<String> preprocess(String cmdargs) {
        List<String> splittedCmdArguments = Splitter.splitBySpaceOutsideQuotes(cmdargs);

        return splittedCmdArguments;
    }

    /**
     * represents steps for executing a command
     * 
     * @param cmdargs
     *            string representing command arguments
     * @param esxRecord
     *            given record in which operations are executed
     * @param logger
     *            log errors and information of the exceptions
     * @throws CommandException
     * 
     * @throws ApplicationErrorException
     */
    public final void proceed(String cmdargs, ESXRecord esxRecord, Logger logger) throws CommandException,
            ApplicationErrorException {
        List<String> result = preprocess(cmdargs);
        validate(result);
        execute(result, esxRecord, logger);
    }

}
