package com.vmware.edu.interpret.reference_refactoring;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Commands.CalcCommand;
import com.vmware.edu.interpret.reference_refactoring.Commands.Command;
import com.vmware.edu.interpret.reference_refactoring.Commands.CountWordsCommand;
import com.vmware.edu.interpret.reference_refactoring.Commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.Commands.ReverseStringCommand;
import com.vmware.edu.interpret.reference_refactoring.Commands.ReverseWordsCommand;
import com.vmware.edu.interpret.reference_refactoring.Commands.SetCommand;

/**
 * Represents a command line interpreter.
 * Singleton pattern is used for the implementation of this class.
 * 
 * @author Antonio
 *
 */
public class CmdInterpreter {
    /**
     * A collection that holds commands of the CmdInterpreter
     */
    private static final Collection<Command> COMMANDS = Arrays
            .asList(new Command[] { new ReverseStringCommand(), new CountWordsCommand(), new ReverseWordsCommand(),
                    new SetCommand(), new GetCommand(), new CalcCommand() });

    /**
     * Map commands of the CmdInterpreter in HashMap using string as a key
     */
    @SuppressWarnings("serial")
    private static final Map<String, Command> COMMAND_MAP = new HashMap<String, Command>() {
        {
            for (Command command : COMMANDS) {
                put(command.getCommandName(), command);
            }
        }
    };

    /**
     * Map that stores variables of the CmdInterpreter instance
     */
    @SuppressWarnings("rawtypes")
    private Map<String, Variable> variables;

    /**
     * Hold instance of CmdInterpreter
     */
    private static CmdInterpreter instance;

    /**
     * @return the variables of CmdInterpreter instance
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Variable> getVariables() {
        return this.variables;
    }

    /**
     * @return an instance of CmdInterpreter
     */
    public static CmdInterpreter getInstance() {
        if (instance == null) {
            instance = new CmdInterpreter();
        }
        return instance;
    }

    /**
     * @return commands of CmdInterpreter
     */
    public Collection<Command> getCommands() {
        return CmdInterpreter.COMMANDS;
    }

    /**
     * @return commands of CmdInterpreter as HashMap
     */
    public Map<String, Command> getCommandMap() {
        return CmdInterpreter.COMMAND_MAP;
    }

    /**
     * Constructor of CmdInterpreter
     * <p>
     * initialize variables field with empty HashMap
     * </p>
     */
    @SuppressWarnings("rawtypes")
    private CmdInterpreter() {
        this.variables = new HashMap<String, Variable>();
    }
}
