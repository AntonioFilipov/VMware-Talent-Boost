package org.talentboost.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger{
    private  String fileName;
    private static FileLogger instance = null;

    private PrintWriter writer = null;
    
    private void setFileName(String fileName) throws FileNotFoundException{
        writer =  new PrintWriter(fileName);
    }
    private FileLogger(String fileName) throws FileNotFoundException{
        this.fileName = fileName;
        setFileName(fileName);
    };
    
    public static FileLogger getInstance(String fileName) throws IOException{
        if(instance == null) {
            instance = new FileLogger(fileName);
         }
         return instance;
    }
    @Override
    public void log(String log) {
        this.writer.println(log);
    }
    
    @Override
    public void close(){
        writer.close();
    }
}
