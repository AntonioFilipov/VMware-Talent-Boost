package org.talentboost.devices;

public class IDEController extends HardDiskController {
    private static final int MAX_SUPPORTED_DISKS = 4;

    public IDEController(String id, String type) {
        super(id, type);
    }

    public DeviceTypes getDeviceType() {
        return DeviceTypes.IDE_CONTROLLER;
    }
    
    @Override
    public int getMaxSupportedDisks(){
    	return this.MAX_SUPPORTED_DISKS;
    }
}
