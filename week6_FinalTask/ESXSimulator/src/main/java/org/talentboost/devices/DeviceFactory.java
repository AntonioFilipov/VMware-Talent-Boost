package org.talentboost.devices;

import java.util.List;

import org.talentboost.customExceptions.CommandException;
import org.talentboost.simulator.ESXRecord;
import org.talentboost.utils.Logger;
import org.talentboost.utils.Splitter;

import java.io.Serializable;


/**
 * Basic class for all device creators
 * @author Antonio
 *
 */

//factory + template pattern + facade
public abstract class DeviceFactory implements Serializable{
    public abstract int getNumberOfCommandArguments();
    
    public abstract Device createDevice(List<String> params, Logger logger) throws CommandException;
    public abstract boolean validate(List<String> cmdargs);
    
    public List<String> preprocess(String cmdargs){
        List<String> splittedCmdArguments = Splitter.splitBySpaceOutsideQuotes(cmdargs);
        return splittedCmdArguments;
    }
    
    public final Device run(String cmdargs, Logger logger) throws CommandException{
        List<String> result = preprocess(cmdargs);
        validate(result);
        Device device = createDevice(result, logger);
        
        return device;
    }
}
