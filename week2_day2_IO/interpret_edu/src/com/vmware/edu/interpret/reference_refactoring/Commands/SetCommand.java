package com.vmware.edu.interpret.reference_refactoring.Commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.vmware.edu.interpret.reference_refactoring.Variable;

/**
 * create a value of a given type and stores it in a given variable
 * 
 * @author Antonio
 *
 */
public class SetCommand implements Command {

    private static final String COMMAND_NAME = "set";
    private static final boolean WORK_WITH_VARIABLE = true;
    private Map<String, Runnable> types = new HashMap<>();

    /**
     * get the name of the command
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
        return SetCommand.WORK_WITH_VARIABLE;
    }

    /**
     * @param cmdargs
     *            arguments of a calling method, splitted by space
     * @param variables
     *            variables of an instance of the CmdInterpreter class
     */
    @Override
    public String execute(String cmdargs, Map<String, Variable> variables) {
        String[] args = cmdargs.split("\\s+");
        if (args.length != 3) {
            System.out.println("Err");
        }
        String variableName = args[0];
        String type = args[1];
        String value = args[2];

        types.put("string", () -> {
            variables.put(variableName, new Variable<String>(variableName, type, value));
        });
        types.put("number", () -> {
            variables.put(variableName, new Variable<Double>(variableName, type, Double.parseDouble(value)));
        });
        types.put("date", () -> {
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date date = sdf.parse(value);
                variables.put(variableName, new Variable<Date>(variableName, type, date));
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        });
        

        if (!types.containsKey(type)) {
            return "Err";
        }
        
        types.get(type).run();

        return "Ok";
    }

}
