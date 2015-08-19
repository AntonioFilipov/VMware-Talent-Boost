package com.vmware.edu.interpret.reference_refactoring.Commands;

import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * gives template for each command in CmdInterpreter
 * @author Antonio
 *
 */
public interface Command {
	String getCommandName();
    @SuppressWarnings("rawtypes")
    String execute(String cmdargs, Map<String, Variable> variables);
    boolean getWorkWithVariable();
}
