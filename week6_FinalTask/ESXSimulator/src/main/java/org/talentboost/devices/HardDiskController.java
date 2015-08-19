package org.talentboost.devices;

import org.talentboost.utils.ErrorBundle;
import org.talentboost.validators.AlphanumericCharacterValidator;

public abstract class HardDiskController extends Device {
    private String id = "";
    private HardDiskControllerTypes type = null;

    public HardDiskController(String id, String type) {
        this.setId(id);
        this.setType(type);
    }

    public abstract int getMaxSupportedDisks();

    public void setId(String id) {
        boolean matches = AlphanumericCharacterValidator.getInstance().validate(id);

        if (!matches) {
            String errorMessage = ErrorBundle.getErrorMessage("ERR_INVALID_ARGUMENT", id);
            throw new IllegalArgumentException(errorMessage);
        }

        this.id = id;
    }

    public HardDiskControllerTypes getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = HardDiskControllerTypes.getTypeFromString(type);
    }

    @Override
    public String getDeviceId() {
        return this.id;
    }

}
