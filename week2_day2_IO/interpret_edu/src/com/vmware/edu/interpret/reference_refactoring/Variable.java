package com.vmware.edu.interpret.reference_refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This generic class holds data for a single variable. Each variable has:
 * <ul>
 * <li>name</li>
 * <li>type</li>
 * <li>value</li>
 * </ul>
 * 
 * @author Antonio
 *
 * @param <T>
 *            type variable which can be used anywhere inside the class
 * 
 */
public class Variable<T> {
    private static final List<String> TYPES = new ArrayList<String>(Arrays.asList("number", "string", "date"));
    private String name;
    private String type;
    private T value;

    /**
     * @return the name of the Variable
     */
    public String getName() {
        return this.name;
    }

    /**
     * set name of the Variable
     * 
     * @param name
     *            <p>
     *            First character must be <b>small letter</b> or <b>_</b>.
     *            </p>
     *            <p>
     *            White space is <b>not permitted</b>.
     *            </p>
     *            <p>
     *            Special characters are <b>not allowed</b>.
     *            </p>
     *            <p>
     *            Subsequent characters may be <b>letters</b>, <b>digits</b>, or
     *            <b>underscore characters</b>.
     *            </p>
     * 
     */
    public void setName(String name) {
        String inputName = name;
        if (!inputName.matches("^[_a-z]\\w*$")) {
            System.out.println("Err");
            return;
        }
        this.name = name;
    }

    /**
     * @return the type of the Variable
     */
    public String getType() {
        return this.type;
    }

    /**
     * set type of the variable
     * 
     * @param type
     *            must be a string which is in TYPES collection
     */
    public void setType(String type) {
        if (!Variable.TYPES.contains(type)) {
            System.out.println("Err");
            return;
        }
        this.type = type;
    }

    /**
     * @return the value of the Variable instance
     */
    public T getValue() {
        return this.value;
    }

    /**
     * set value of the Variable instance
     * 
     * @param value
     *            generic type value
     */
    public void setValue(T value) {
        String valueType = value.getClass().getName();
        if ((valueType.equals("String") && !this.type.equals("string")) || 
                (valueType.equals("Integer") || valueType.equals("Double")) && !this.type.equals("number") ||
                valueType.equals("Date") && !this.type.equals("Date")) {
            throw new IllegalArgumentException("Invalid types");
        }
        
        this.value = value;
    }

    /**
     * Create an instance of Variable class.
     * 
     * @param name
     *            the name of the variable.
     * 
     * @param type
     * @param value
     */
    public Variable(String name, String type, T value) {
        this.setName(name);
        this.setType(type);
        this.setValue(value);
    }

}
