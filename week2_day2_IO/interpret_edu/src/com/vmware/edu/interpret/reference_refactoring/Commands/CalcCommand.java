package com.vmware.edu.interpret.reference_refactoring.Commands;

import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Operations;
import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * the command performs a simplistic operation between two variables and stores
 * the result in third variable
 * 
 * @author Antonio
 *
 */
public class CalcCommand implements Command {

    private static final String COMMAND_NAME = "calc";
    private static final boolean WORK_WITH_VARIABLE = true;

    /**
     * return the name of the command
     */
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }
    
    @Override
    public boolean getWorkWithVariable() {
        return CalcCommand.WORK_WITH_VARIABLE;
    }

    /**
     * @param cmdargs
     *            arguments of a calling method, splitted by a space
     * @param variables
     *            variables of an instance of the CmdInterpreter class
     */
    @SuppressWarnings("rawtypes")
    @Override
    public String execute(String cmdargs, Map<String, Variable> variables) {
        String[] args = cmdargs.split("\\s+");
        System.out.println(cmdargs);
        if (args.length != 4) {
            System.out.println("Err");
        }
        String resultVariable = args[0];
        String firstVariable = args[1];
        String operation = args[2];
        String secondVariable = args[3];

        if (variables.containsKey(firstVariable) && variables.containsKey(secondVariable)) {
            Variable first = variables.get(firstVariable);
            Variable second = variables.get(secondVariable);

            Operations op = new Operations(first, second, operation, resultVariable);
            op.calculate(variables);
        }

        return "Ok";
    }

}
