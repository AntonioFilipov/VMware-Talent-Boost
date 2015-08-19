package org.talentboost.simulator;

import java.util.HashMap;
import java.util.Map;

import org.talentboost.devices.Device;
import org.talentboost.devices.HardDiskController;

public class HardDiskControllerRecord {
    private Map<HardDiskController, Map<String, Device>> hdRecord = new HashMap<HardDiskController, Map<String, Device>>();
    private HardDiskController hardDiskController;
    
    public HardDiskControllerRecord(HardDiskController hardDiskController){
        this.hdRecord.put(hardDiskController, new HashMap<String, Device>());
        this.hardDiskController = hardDiskController;
    }
    
    public void addRecord(Device device) {
        this.hdRecord.get(this.hardDiskController).put(device.getDeviceId(), device);
    }
    
    public Map<HardDiskController, Map<String, Device>> getRecord(){
        return this.hdRecord;
    }
    
    public Map<String, Device> getDevices(){
        return this.hdRecord.get(this.hardDiskController);
    }
    
    public HardDiskController getHDController(){
        return this.hardDiskController;
    }
    
    public boolean containsID(String ID){
        if (this.hdRecord.get(this.hardDiskController).containsKey(ID)) {
            return true;
        }
        return false;
    }
    
    public void deleteDeviceRecord(String deviceID){
        this.getDevices().remove(deviceID);
    }
}
