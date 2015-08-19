package org.talentboost.utils;

import java.io.InputStream;

public class ConsoleReader {
    private InputStream input; 
    
    public ConsoleReader(InputStream input){
        this.setInput(input);
    }

    public InputStream getInput() {
        return input;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }
}
