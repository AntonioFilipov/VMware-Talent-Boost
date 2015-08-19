package org.talentboost.customExceptions;

import org.talentboost.commands.Command;
import org.talentboost.utils.ErrorBundle;

/**
 * This exception is thrown when command is not valid
 * @author Antonio
 *
 */
public class CommandException extends Exception {
    private Command command;

    public CommandException(String message) {
        super(message);
    }

    public CommandException(Command command, Throwable cause) {
        super(String.format(ErrorBundle.getErrorMessage("ERR_CANNOT_EXECUTE_COMMAND", ""),
                command.getCommandName(), cause.getMessage()), cause);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

}