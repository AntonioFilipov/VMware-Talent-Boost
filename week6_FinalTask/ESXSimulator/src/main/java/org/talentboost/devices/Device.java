package org.talentboost.devices;
import java.io.Serializable;

/**
 * Basic class for all devices
 * @author Antonio
 *
 */
public abstract class Device implements Serializable{
    public abstract String getDeviceId();
    public abstract DeviceTypes getDeviceType();
}
