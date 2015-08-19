package org.talentboost.devices;

import org.talentboost.utils.ErrorBundle;
import org.talentboost.utils.Logger;
import org.talentboost.validators.AlphanumericCharacterValidator;
import org.talentboost.validators.AlphanumericCharactersAndSpaceValidator;

public class HardDisk extends DeviceComponent {
    private String id = "";
    private long size = 0;
    private String hardDiskControllerID = "";

    public HardDisk(String id, long size, String hardDiskControllerID) throws IllegalArgumentException{
        this.setId(id);
        this.setSize(size);
        this.setHardDiskControllerID(hardDiskControllerID);
    }
 
    public void setId(String id) {
        boolean matches = AlphanumericCharacterValidator.getInstance().validate(id);

        if (!matches) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT", id);
            throw new IllegalArgumentException(errorMessage);
        }
        this.id = id;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setHardDiskControllerID(String hardDiskControllerID) {
        boolean matches = AlphanumericCharacterValidator.getInstance().validate(hardDiskControllerID);

        if (!matches) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT", hardDiskControllerID);
            throw new IllegalArgumentException(errorMessage);
        }
        this.hardDiskControllerID = hardDiskControllerID;
    }

    @Override
    public String getDeviceId() {
        return this.id;
    }

    @Override
    public DeviceTypes getDeviceType() {
        return DeviceTypes.HARDDISK;
    }

    @Override
    public String getParentDeviceId() {
        return this.hardDiskControllerID;
    }

}
