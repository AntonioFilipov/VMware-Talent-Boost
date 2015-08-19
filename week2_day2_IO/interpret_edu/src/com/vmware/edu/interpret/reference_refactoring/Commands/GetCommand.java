package com.vmware.edu.interpret.reference_refactoring.Commands;

import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * 
 * @author Antonio
 *
 */
public class GetCommand implements Command{

	private static final String COMMAND_NAME = "get";
	private static final boolean WORK_WITH_VARIABLE = true;
	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
	
    @Override
    public boolean getWorkWithVariable() {
        return this.WORK_WITH_VARIABLE;
    }

	@Override
	public String execute(String cmdargs, Map<String, Variable> variables) {
		String[] args = cmdargs.split("\\s+");
		if (args.length != 1) {
			System.out.println("Invalid arguments");
		}
		String variableName = args[0];
		
		Variable var;
		if (variables.containsKey(variableName)) {
		    var = variables.get(variableName);
		    return "["+var.getType()+"] "+var.getValue();
		}
		
		return "Err";
	}



}
