package org.talentboost.simulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.talentboost.commands.ReadVMCommand;
import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.inputParser.CommandParser;
import org.talentboost.utils.ConsoleLogger;
import org.talentboost.utils.FileLogger;
import org.talentboost.utils.Logger;

public class ESXSimulator {
    private ESX system;
    private ESXRecord esxRecord;
    private Logger logger;
    
    public ESXSimulator(ESX system, Logger logger){
        this.system = system;
        this.esxRecord = new ESXRecord(this.system);
        this.logger = logger;
    }
    
    private void readCommandsFromFile() throws CommandException{
        try {
            File file = new File("file.txt");
            InputStream inputStream = new FileInputStream(file);

            // facade
            CommandParser.processInput(inputStream, esxRecord, logger);
        } catch (ApplicationErrorException e) {
            e.printStackTrace();
            logger.close();
            System.exit(1);
        } catch (FileNotFoundException e) { 
            logger.log(e.getMessage());
        } catch (IOException e) {
            logger.log(e.getMessage());

        }
    }
    
    private void readCommandsFromComandLine() throws CommandException{
        try {
            InputStream inputStream = System.in;

            // facade
            CommandParser.processInput(inputStream, esxRecord, logger);
        } catch (ApplicationErrorException e) {
            e.printStackTrace();
            logger.close();
            System.exit(1);
        }
    }
    
    
    public void loadVMs() throws CommandException, ApplicationErrorException {
        File[] files = new File("vms").listFiles();
        ReadVMCommand readCommand = new ReadVMCommand();

        for (File file : files) {
            if (!file.isDirectory()) {
                String vmID = file.getName().replaceAll("\\D+","");
                List<String> vmIDasList = new ArrayList<String>();
                vmIDasList.add(vmID);
                readCommand.execute(vmIDasList, this.esxRecord, this.logger);
            }
        }
    }
    
    public void simulate(ESXSimulatorTypes type) throws CommandException{
        if (type == ESXSimulatorTypes.COMMAND_LINE) {
            this.readCommandsFromComandLine();
        }else if (type == ESXSimulatorTypes.FILE){
            this.readCommandsFromFile();
        }
    }

}
