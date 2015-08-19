package com.vmware.edu.interpret.reference_refactoring;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.Calendar;


/**
 * Calculate result between two variables and save it to third variable
 * 
 * @author Antonio
 *
 */
public class Operations {
    @SuppressWarnings("rawtypes")
    private Variable firstOperand;
    @SuppressWarnings("rawtypes")
    private Variable secondOperand;
    private String operation;
    private String result;
    private Map<String, Runnable> stringOperations = new HashMap<>();
    private Map<String, Runnable> numericOperations = new HashMap<>();
    private Map<String, Runnable> dateOperations = new HashMap<>();


    /**
     * Constructor of the class
     * 
     * @param first
     * @param second
     * @param operation
     * @param result
     */
    @SuppressWarnings("rawtypes")
    public Operations(Variable first, Variable second, String operation, String result) {
        this.firstOperand = first;
        this.secondOperand = second;
        this.operation = operation;
        this.result = result;
    }

    /**
     * Calculating result of the operation
     * 
     * @param variables
     */
    @SuppressWarnings("rawtypes")
    public void calculate(Map<String, Variable> variables) {
        stringOperations.put(
                "+",
                () -> {
                    variables.put(result,
                            new Variable<String>(result, "string", String.valueOf(firstOperand.getValue())
                                    + secondOperand.getValue()));
                });
        stringOperations.put(
                "*",
                () -> {
                    String repeater = repeat(String.valueOf(firstOperand.getValue()),
                            ((Double) secondOperand.getValue()).intValue());
                    variables.put(result, new Variable<String>(result, "string", repeater));
                });

        numericOperations.put(
                "+",
                () -> {
                    variables.put(result,
                            new Variable<Double>(result, "number", ((Number) firstOperand.getValue()).doubleValue()
                                    + ((Number) secondOperand.getValue()).doubleValue()));
                });
        numericOperations.put(
                "-",
                () -> {
                    variables.put(result,
                            new Variable<Double>(result, "number", ((Number) firstOperand.getValue()).doubleValue()
                                    - ((Number) secondOperand.getValue()).doubleValue()));
                });
        numericOperations.put(
                "*",
                () -> {
                    variables.put(result,
                            new Variable<Double>(result, "number", ((Number) firstOperand.getValue()).doubleValue()
                                    * ((Number) secondOperand.getValue()).doubleValue()));
                });
        dateOperations.put(
                "+",
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.setTime((Date) firstOperand.getValue());
                    
                    c.add(Calendar.DATE, (int) ((Number) secondOperand.getValue()).doubleValue());
                    
                    variables.put(result,
                            new Variable<Date>(result, "date", c.getTime()));
                });
        
        dateOperations.put(
                "-",
                () -> {
                    Calendar c = Calendar.getInstance();
                    c.setTime((Date) firstOperand.getValue());
                    
                    c.add(Calendar.DATE, -(int) ((Number) secondOperand.getValue()).doubleValue());
                    
                    variables.put(result,
                            new Variable<Date>(result, "date", c.getTime()));
                });


        if (firstOperand.getType().equals("number") && secondOperand.getType().equals("number")) {
            if (!numericOperations.containsKey(operation)) {
                throw new IllegalArgumentException("Operation is invalid");
            }
            numericOperations.get(this.operation).run();
        } else if (firstOperand.getType().equals("string")) {
            if (!stringOperations.containsKey(operation)) {
                throw new IllegalArgumentException("Operation is invalid");
            }
            stringOperations.get(this.operation).run();
        }else if (firstOperand.getType().equals("date") && secondOperand.getType().equals("number")) {
            if (!dateOperations.containsKey(operation)) {
                throw new IllegalArgumentException("Operation is invalid");
            }
            dateOperations.get(this.operation).run();
        }
    }

    /**
     * Repeat string n times
     * @param str
     * @param times
     * @return
     */
    private static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}
