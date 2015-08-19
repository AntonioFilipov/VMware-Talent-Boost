package com.vmware.edu.interpret.reference_refactoring.Commands;

import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * reverses the letter in the provided string
 * @author Antonio
 *
 */
public class ReverseStringCommand implements Command {

	private static final String COMMAND_NAME = "reverse";
    private static final boolean WORK_WITH_VARIABLE = false;

    /**
     * return the name of the command
     */
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * return true/false if method works with variable
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
		return new StringBuilder(cmdargs).reverse().toString();
	}

}
