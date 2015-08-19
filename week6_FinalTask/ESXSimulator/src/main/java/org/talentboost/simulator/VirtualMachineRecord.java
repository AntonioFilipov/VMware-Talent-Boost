package org.talentboost.simulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.Serializable;

import org.talentboost.devices.Device;
import org.talentboost.devices.DeviceTypes;

public class VirtualMachineRecord implements Serializable {
    private static final int MAX_IDE_CONTROLLERS = 1;
    private static final int MAX_SCSI_CONTROLLERS = 4;

    private Map<VirtualMachine, Map<String, DeviceRecord>> vmRecord = new HashMap<VirtualMachine, Map<String, DeviceRecord>>();
    private VirtualMachine vm;

    public VirtualMachineRecord(VirtualMachine vm) {
        this.vmRecord.put(vm, new HashMap<String, DeviceRecord>());
        this.vm = vm;
    }

    public void addRecord(DeviceRecord devRecord) throws ClassNotFoundException {
        Device device = devRecord.getDevice();

        if (device.getDeviceType() == DeviceTypes.IDE_CONTROLLER) {
            if (isReachingMaxDeviceOfType(device.getDeviceType(), MAX_IDE_CONTROLLERS)) {
                //TODO 
                System.out.println("reaching");
            }
        } else if (device.getDeviceType() == DeviceTypes.SCSI_CONTROLLER) {
            if (isReachingMaxDeviceOfType(device.getDeviceType(), MAX_SCSI_CONTROLLERS)) {
                //TODO
                System.out.println("reaching");
            }
        }

        this.getDeviceRecord().put(devRecord.getDevice().getDeviceId(), devRecord);
    }

    public DeviceRecord getRecord(String id) {
        return getDeviceRecord().get(id);
    }

    public Map<String, DeviceRecord> getDeviceRecord() {
        return this.vmRecord.get(this.vm);
    }

    public VirtualMachine getVM() {
        return this.vm;
    }

    public boolean containsID(String ID) {
        if (this.vmRecord.get(this.vm).containsKey(ID)) {
            return true;
        }
        return false;
    }

    public void deleteDeviceRecord(String deviceID) {
        this.getDeviceRecord().remove(deviceID);
    }

    public void display() {
        for (Entry<String, DeviceRecord> entry : this.getDeviceRecord().entrySet()) {
            System.out.printf("%-10s %-20s %-20s %-20s\n", "ID", "Name", "Memmory", "CPU");
            System.out.println(entry.getValue().getDevice());
        }
    }

    // public int getNumberOfDeviceType(Class<?> t){
    // int numberOfDeviceType = 0;
    //
    // for (Entry<String, DeviceRecord> entry :
    // this.getDeviceRecord().entrySet()){
    // Device device = entry.getValue().getDevice();
    // if (t.isInstance(device) ) {
    // numberOfDeviceType++;
    // }
    // }
    //
    // return numberOfDeviceType;
    // }

    public int getNumberOfDeviceType(DeviceTypes type) {
        int numberOfDeviceType = 0;

        for (Entry<String, DeviceRecord> entry : this.getDeviceRecord().entrySet()) {
            Device device = entry.getValue().getDevice();
            if (device.getDeviceType() == type) {
                numberOfDeviceType++;
            }
        }

        return numberOfDeviceType;
    }

    public boolean isReachingMaxDeviceOfType(DeviceTypes type, int maxDeviceTypeCount) {
        if (getNumberOfDeviceType(type) >= maxDeviceTypeCount) {
            return true;
        }

        return false;
    }

}
