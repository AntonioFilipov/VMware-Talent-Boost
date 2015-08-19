package org.talentboost.simulator;

import java.io.IOException;

import org.talentboost.customExceptions.ApplicationErrorException;
import org.talentboost.customExceptions.CommandException;
import org.talentboost.utils.FileLogger;
import org.talentboost.utils.Logger;

public class ESXManager {
    
    public static void main(String[] args) throws CommandException, IOException, ApplicationErrorException {

        ESX system = new ESX();
        Logger logger = FileLogger.getInstance("fileLogger.txt");
        ESXSimulator simulator = new ESXSimulator(system, logger);
        simulator.loadVMs();
        simulator.simulate(ESXSimulatorTypes.COMMAND_LINE);
    }
}
