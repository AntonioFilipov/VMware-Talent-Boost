package com.vmware.edu.interpret.reference_refactoring_test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Commands.Command;
import com.vmware.edu.interpret.reference_refactoring.Commands.SetCommand;
import com.vmware.edu.interpret.reference_refactoring.Variable;

public class TestSetCommand {

    private SetCommand set;
    private Map<String, Variable> variables;

    @Before
    public void executedBeforeEach(){
        CmdInterpreter cmd = CmdInterpreter.getInstance();
        set = new SetCommand();
        variables = cmd.getVariables();
    }

    @Test
    public void testSetCommandStringType(){
        set.execute("toni string filipov", variables);
        assertTrue(variables.containsKey("toni"));
    }
    
    @Test
    public void testSetCommandNumberType(){
        set.execute("apple number 4",variables);
        assertTrue(variables.containsKey("apple"));
    }

}
