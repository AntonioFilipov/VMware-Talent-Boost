package org.talentboost.simulator;

import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;


public class ESXRecord implements Serializable {
    private Map<ESX, Map<String, VirtualMachineRecord>> esxRecord = new HashMap<ESX, Map<String, VirtualMachineRecord>>();
    private ESX system;

    public ESXRecord(ESX system) {
        this.esxRecord.put(system, new HashMap<String, VirtualMachineRecord>());
        this.system = system;
    }

    public void addRecord(VirtualMachineRecord vmRecord) {
        this.getESXRecord().put(vmRecord.getVM().getID(), vmRecord);
    }
    
    public Map<String, VirtualMachineRecord> getESXRecord() {
        return this.esxRecord.get(this.system);
    }

    public boolean containsID(String id) {
        if (this.esxRecord.get(this.system).containsKey(id)) {
            return true;
        }

        return false;
    }

    public VirtualMachineRecord getVMRecord(String vmID) {
        return this.esxRecord.get(this.system).get(vmID);
    }

    public void deleteESXRecord(String id){
        this.getESXRecord().remove(id);
    }
    
    public ESX getESX() {
        return this.system;
    }
}
