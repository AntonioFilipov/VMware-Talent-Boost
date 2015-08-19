package com.vmware.edu.interpret.reference_refactoring_test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.vmware.edu.interpret.reference_refactoring.Commands.CalcCommand;
import com.vmware.edu.interpret.reference_refactoring.CmdInterpreter;
import com.vmware.edu.interpret.reference_refactoring.Commands.GetCommand;
import com.vmware.edu.interpret.reference_refactoring.Commands.SetCommand;
import com.vmware.edu.interpret.reference_refactoring.Variable;

public class TestCalcCommand {

    private GetCommand get;
    private SetCommand set;
    private CalcCommand calc;
    private Map<String, Variable> variables;

    @Before
    public void executedBeforeEach() {
        CmdInterpreter cmd = CmdInterpreter.getInstance();
        get = new GetCommand();
        set = new SetCommand();
        calc = new CalcCommand();
        variables = cmd.getVariables();
    }

    @Test
    public void testCalcCommandStringPlusString() {
        set.execute("opel string astra",variables);
        set.execute("vw string passat",variables);
        calc.execute("result opel + vw",variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("[string] astrapassat", "["+result.getType()+"] "+result.getValue());
    }
    
    @Test
    public void testCalcCommandStringPlusNumber() {
        set.execute("opel string astra",variables);
        set.execute("water number 53",variables);
        calc.execute("result opel + water",variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("[string] astra53.0", "["+result.getType()+"] "+result.getValue());
    }
    
    @Test
    public void testCalcCommandStringMultipliedByNumber() {
        set.execute("opel string astra", variables);
        set.execute("water number 3", variables);
        calc.execute("result opel * water", variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("[string] astraastraastra", "["+result.getType()+"] "+result.getValue());
    }
    
    @Test
    public void testCalcCommandNumberPlusNumber() {
        set.execute("apple number 4", variables);
        set.execute("water number 3", variables);
        calc.execute("result apple + water", variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("[number] 7.0", "["+result.getType()+"] "+result.getValue());
    }
    
    @Test
    public void testCalcCommandNumberMinusNumber() {
        set.execute("apple number 4", variables);
        set.execute("water number 3", variables);
        calc.execute("result apple - water", variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("[number] 1.0", "["+result.getType()+"] "+result.getValue());
    }
    
    @Test
    public void testCalcCommandNumberMultipliedByNumber() {
        set.execute("apple number 4", variables);
        set.execute("water number 3", variables);
        calc.execute("result apple * water", variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("[number] 12.0", "["+result.getType()+"] "+result.getValue());
    }
    
    @Test
    public void testCalcCommandDatePlusNumber() {
        set.execute("apple date 20-07-2015", variables);
        set.execute("water number 3", variables);
        calc.execute("result apple + water", variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("Thu Jul 23 00:00:00 EEST 2015", result.getValue().toString());
    }
    
    @Test
    public void testCalcCommandDateMinusNumber() {
        set.execute("apple date 20-07-2015", variables);
        set.execute("water number 3", variables);
        calc.execute("result apple - water", variables);
        assertTrue(variables.containsKey("result"));
        Variable result = variables.get("result");
        assertEquals("Fri Jul 17 00:00:00 EEST 2015", result.getValue().toString());
    }
}
