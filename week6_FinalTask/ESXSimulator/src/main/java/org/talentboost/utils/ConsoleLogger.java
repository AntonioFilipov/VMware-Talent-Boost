package org.talentboost.utils;

public class ConsoleLogger implements Logger{
    private static ConsoleLogger instance = null;
    
    private ConsoleLogger(){};
    
    public static ConsoleLogger getInstance(){
        if (instance == null) {
            instance = new ConsoleLogger();
        }
        
        return instance;
    }
    
    public void log(String log){
        System.out.println(log);
    }

    @Override
    public void close() {
        System.out.println("");
    }
}
