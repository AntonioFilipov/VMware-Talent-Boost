package org.talentboost.devices;

import java.util.Locale;

import org.talentboost.utils.ErrorBundle;

public enum HardDiskControllerTypes {
    IDE, SCSI;

    public static HardDiskControllerTypes getValue(String inputString) {
        for (HardDiskControllerTypes c : HardDiskControllerTypes.values()) {
            if (c.name().equals(inputString)) {
                return c;
            }
        }
        return null;
    }

    public static HardDiskControllerTypes getTypeFromString(String text) {
        HardDiskControllerTypes result = getValue(text);
        if (result == null) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_TYPE_DEVICE", "");
            throw new IllegalArgumentException(errorMessage);
        }
        
        return result;
    }
}
