package com.vmware.edu.interpret.reference_refactoring_test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.Commands.SetCommand;
import com.vmware.edu.interpret.reference_refactoring.Variable;

public class TestGetCommand {

    private GetCommand get;
    private SetCommand set;
    private Map<String, Variable> variables;


    @Before
    public void executedBeforeEach() {
        CmdInterpreter cmd = CmdInterpreter.getInstance();
        get = new GetCommand();
        set = new SetCommand();
        variables = cmd.getVariables();

    }

    @Test
    public void testGetCommandStringType() {
        set.execute("opel string astra", variables);
        Variable var = variables.get("opel");
        assertEquals("[string] astra", "["+var.getType()+"] "+var.getValue());
    }

    @Test
    public void testGetCommandNumericType() {
        set.execute("water number 4", variables);
        Variable var = variables.get("water");
        assertEquals("[number] 4.0", "["+var.getType()+"] "+var.getValue());
    }

}
