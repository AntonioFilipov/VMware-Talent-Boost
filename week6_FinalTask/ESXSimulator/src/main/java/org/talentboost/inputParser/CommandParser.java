package org.talentboost.inputParser;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.talentboost.commands.Command;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESX;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;

public class CommandParser {

    public static void processInput(InputStream in, ESXRecord systemRecord, Logger logger) throws CommandException, ApplicationErrorException{
        Scanner inscan = new Scanner(in);
        try {
            while (true) {
                try {
                    String line = inscan.nextLine().trim();
                    processLine(line, systemRecord, logger);
                } catch (CommandException e) {
                    logger.log(e.getMessage());
                }
            }
        } catch (NoSuchElementException e) {
            logger.log(e.getMessage());
        } finally {
            inscan.close();
        }
    }

    private static void processLine(String line, ESXRecord systemRecord, Logger logger) throws CommandException, ApplicationErrorException {
        Scanner linescan = new Scanner(line);

        try {
            String command = linescan.next();
            String cmdargs;
            if (!linescan.hasNext()) {
                cmdargs = "";
            } else {
                cmdargs = linescan.nextLine().trim();
            }

            Command commandToExecute = systemRecord.getESX().getCommandMap().get(command);
            if (commandToExecute == null) {
                String errorMessage = ErrorBundle.getErrorMessage("ERR_UNKNOWN_COMMAND", command);
                logger.log(errorMessage);
                throw new CommandException(errorMessage);
            }

            commandToExecute.proceed(cmdargs, systemRecord, logger);

        } catch (NoSuchElementException e) {
            logger.log(e.getMessage());
        } catch (CommandException e) {
            logger.log(e.getMessage());
        } finally{
            linescan.close();
        }
    }
}
