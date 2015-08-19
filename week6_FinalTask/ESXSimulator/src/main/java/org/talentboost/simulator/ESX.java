package org.talentboost.simulator;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

import org.talentboost.commands.AddDeviceCommand;
import org.talentboost.commands.Command;
import org.talentboost.commands.CreateVMCommand;
import org.talentboost.commands.DeleteDeviceCommand;
import org.talentboost.commands.DeleteVMCommand;
import org.talentboost.commands.DisplayVMCommand;
import org.talentboost.commands.EditVMCommand;
import org.talentboost.commands.HelpCommand;
import org.talentboost.commands.ReadVMCommand;
import org.talentboost.commands.SaveVMCommand;
import org.talentboost.commands.StopESXCommand;


public class ESX implements Serializable{
    
    private static final Collection<Command> COMMANDS = Arrays
            .asList(new Command[] { new CreateVMCommand(), new DeleteVMCommand(), new DisplayVMCommand(),
                    new EditVMCommand(), new HelpCommand(), new AddDeviceCommand(), new DeleteDeviceCommand(),
                    new SaveVMCommand(), new ReadVMCommand(), new StopESXCommand()});

    private static final Map<String, Command> COMMAND_MAP = new HashMap<String, Command>() {
        {
            for (Command command : COMMANDS) {
                put(command.getCommandName(), command);
            }
        }
    };
    
    public Map<String, Command> getCommandMap() {
        return ESX.COMMAND_MAP;
    }
    
    public Collection<Command> getCommands(){
        return ESX.COMMANDS;
    }

}
