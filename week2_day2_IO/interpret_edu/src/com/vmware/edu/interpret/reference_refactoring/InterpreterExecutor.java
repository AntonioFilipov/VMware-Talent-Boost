package com.vmware.edu.interpret.reference_refactoring;

import java.io.InputStream;
import java.util.Scanner;

/**
 * create an instance of CmdInterpreter
 * 
 * @author Antonio
 *
 */
public class InterpreterExecutor {

    /**
     * main method of the project
     * 
     * @param args
     */
    public static void main(String[] args) {
        InputStream instr = System.in;

        CmdInterpreter cmd = CmdInterpreter.getInstance();
        Processor.processInput(instr, cmd);
    }
}
