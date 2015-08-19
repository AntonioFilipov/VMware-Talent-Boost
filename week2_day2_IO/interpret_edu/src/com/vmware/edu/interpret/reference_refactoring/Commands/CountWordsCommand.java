package com.vmware.edu.interpret.reference_refactoring.Commands;

import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * count number of words in the provided string 
 * @author Antonio
 *
 */
public class CountWordsCommand implements Command {

	private static final String COMMAND_NAME = "count-words";
    private static final boolean WORK_WITH_VARIABLE = false;

    /**
     * return the name of the command
     */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
	
    @Override
    public boolean getWorkWithVariable() {
        return CountWordsCommand.WORK_WITH_VARIABLE;
    }
    /**
     * @param cmdargs
     *            arguments of a calling method, splitted by space
     * @param variables
     *            variables of an instance of the CmdInterpreter class
     */
	@SuppressWarnings("rawtypes")
    @Override
	public String execute(String cmdargs, Map<String, Variable> variables) {
		int count = cmdargs.split("\\s+").length;
		return String.valueOf(count);
	}

}
