package org.talentboost.simulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.Serializable;

import org.talentboost.devices.Device;
import org.talentboost.devices.DeviceComponent;
import org.talentboost.devices.HardDisk;
import org.talentboost.devices.IDEController;
import org.talentboost.devices.SCSIController;

public class DeviceRecord implements Serializable{
    private Map<Device, Map<String, DeviceComponent>> deviceRecord = new HashMap<Device, Map<String, DeviceComponent>>();
    private Device device;
    
    public DeviceRecord(Device device){
        this.deviceRecord.put(device, new HashMap<String, DeviceComponent>());
        this.device = device;
    }
    
    public void addRecord(DeviceComponent devComponent) throws ClassNotFoundException {
        if (device instanceof HardDisk) {
            if (this.device instanceof IDEController) {
            	IDEController controller = (IDEController) this.device;
                if (this.getNumberOfHardDisk() >= controller.getMaxSupportedDisks()) {
                    //TODO
                    System.out.println("adsad");
                }
            }else if(device instanceof SCSIController) {
            	IDEController controller = (IDEController) this.device;
                if (this.getNumberOfHardDisk() >= controller.getMaxSupportedDisks()) {
                    //TODO
                    System.out.println("adsad");
                }
            }
        }
        
        this.deviceRecord.get(this.device).put(devComponent.getDeviceId(), devComponent);
    }
    
    public Map<Device, Map<String, DeviceComponent>> getRecord(){
        return this.deviceRecord;
    }
    
    public Map<String, DeviceComponent> getDevices(){
        return this.deviceRecord.get(this.device);
    }
    
    public Device getDevice(){
        return this.device;
    }
    
    public boolean containsID(String ID){
        if (this.deviceRecord.get(this.device).containsKey(ID)) {
            return true;
        }
        return false;
    }
    
    public void deleteDeviceRecord(String deviceID){
        this.getDevices().remove(deviceID);
    }
    
    public void display(){
        for (Device key : this.deviceRecord.keySet()) {
            System.out.println(key);
        }
    }
    
    private int getNumberOfHardDisk(){
        int numberOfDeviceType = 0;
        
        for (Entry<String, DeviceComponent> entry : this.getDevices().entrySet()){
            if (entry instanceof HardDisk) {
                numberOfDeviceType++;
            }
        }
        
        return numberOfDeviceType;
    }
}
