package com.vmware.edu.interpret.reference_refactoring;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.vmware.edu.interpret.reference_refactoring.Commands.Command;

/**
 * take user input and execute command
 * 
 * @author Antonio
 *
 */
public class Processor {

    /**
     * process given user input
     * 
     * @param instr
     *            user input
     * @param cmd
     *            instance of CmdInterpreter
     */
    public static void processInput(InputStream instr, CmdInterpreter cmd) {
        Scanner inscan = new Scanner(instr);
        try {
            while (true) {
                String line = inscan.nextLine().trim();
                processLine(line, cmd);
            }
        } catch (NoSuchElementException e) {
            // end of file reached
        } finally {
            inscan.close();
        }
    }

    /**
     * process single line of input and execute given command
     * 
     * @param line
     *            single line of input
     * @param cmd
     *            instance of CmdInterpreter
     * 
     */
    private static void processLine(String line, CmdInterpreter cmd) {
        Scanner linescan = new Scanner(line);
        try {
            String command = linescan.next();
            String cmdargs = linescan.nextLine().trim();

            Command commandToExecute = cmd.getCommandMap().get(command);
            if (commandToExecute == null) {
                System.out.println("Err: Unknown command " + command);
                return;
            }
            boolean isWorkingWithVariable = commandToExecute.getWorkWithVariable();
            String result;
            if (isWorkingWithVariable) {
                result = commandToExecute.execute(cmdargs, cmd.getVariables());
            } else {
                result = commandToExecute.execute(cmdargs, null);
            }
            System.out.println(result);
        } catch (NoSuchElementException e) {
            System.out.println("Cannot parse command: " + line);
        }
        linescan.close();
    }
}
