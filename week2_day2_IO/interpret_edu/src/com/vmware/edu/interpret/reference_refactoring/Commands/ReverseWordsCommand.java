package com.vmware.edu.interpret.reference_refactoring.Commands;

import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * reverses the order of the words in the provided string
 * @author Antonio
 *
 */
public class ReverseWordsCommand implements Command {

	private static final String COMMAND_NAME = "reverse-words";
    private static final boolean WORK_WITH_VARIABLE = false;

    /**
     * return name of the command
     */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

    /**
     * return true/false if method works with a variable
     */
    @Override
    public boolean getWorkWithVariable() {
        return this.WORK_WITH_VARIABLE;
    }
    
    /**
     * @param cmdargs
     *            arguments of a calling method, splitted by space
     * @param variables
     *            variables of an instance of the CmdInterpreter class
     */
	@Override
	public String execute(String cmdargs, Map<String, Variable> variables) {
		StringBuilder revargs = new StringBuilder();
		String[] words = cmdargs.split(" ");
		for (int i = words.length-1; i >= 0; i--) {
		    revargs.append(words[i]);
		    if (i > 0) {
		        revargs.append(" ");
		    }
		}
		return revargs.toString();
	}

}
