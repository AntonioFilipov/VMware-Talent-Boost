package org.talentboost.devices;

public class SCSIController extends HardDiskController {
	private static final int MAX_SUPORTED_DISKS = 16;
	
	public SCSIController(String id, String type) {
		super(id, type);
	}
	
	@Override
	public int getMaxSupportedDisks(){
		return this.MAX_SUPORTED_DISKS;
	}

	@Override
	public DeviceTypes getDeviceType() {
		return DeviceTypes.SCSI_CONTROLLER;
	}
}
