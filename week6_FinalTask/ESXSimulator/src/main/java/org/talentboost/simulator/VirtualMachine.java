package org.talentboost.simulator;

import java.util.HashMap;
import java.util.Map;

import org.talentboost.devices.Device;
import org.talentboost.validators.AlphanumericCharacterValidator;
import org.talentboost.validators.AlphanumericCharactersAndSpaceValidator;
import java.io.Serializable;
/**
 * An entity similar to physical computer
 * 
 * @author Antonio
 *
 */
public class VirtualMachine implements Serializable
 {
	private static final int MIN_NUMBER_OF_CPU = 1;
	private static final int MAX_NUMBER_OF_CPU = 8;
	


	private String ID = "";
	private String name = "";
	private long memory = 0L;
	private int numberOfCPU = MIN_NUMBER_OF_CPU;


	public VirtualMachine(String uniqueID, String name, long memory){
		this.setId(uniqueID);
		this.setName(name);
		this.setMemory(memory);
	}

	public VirtualMachine(String uniqueID, String name, long memory, int numberOfCPU) {
		this(uniqueID, name, memory);
		this.numberOfCPU = numberOfCPU;
	}

	public String getID() {
		return this.ID;
	}

	public void setId(String ID) {
		boolean matches = AlphanumericCharacterValidator.getInstance()
				.validate(ID);

		if (!matches) {
			throw new IllegalArgumentException("Invalid ID!");
		}

		this.ID = ID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		boolean matches = AlphanumericCharactersAndSpaceValidator.getInstance()
				.validate(name);

		if (!matches) {
			throw new IllegalArgumentException("Invalid virtual machine name!");
		}

		this.name = name;
	}

	public long getMemory() {
		return this.memory;
	}

	public void setMemory(long memory) {
		if (memory < 0) {
			throw new IllegalArgumentException(
					"Memory cannot be less than zero!");
		}
		this.memory = memory;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-20s %-20s %-20s\n", this.ID, this.name,
				this.memory, this.numberOfCPU);
	}

	public int getNumberOfCPU() {
		return numberOfCPU;
	}

	public void setNumberOfCPU(int numberOfCPU) {
		if (numberOfCPU < MIN_NUMBER_OF_CPU) {
			throw new IllegalArgumentException(
					"Number of CPU cannot be less than " + MIN_NUMBER_OF_CPU);
		} else if (numberOfCPU > MAX_NUMBER_OF_CPU) {
			throw new IllegalArgumentException(
					"Number of CPU cannot be great than " + MAX_NUMBER_OF_CPU);
		}
		this.numberOfCPU = numberOfCPU;
	}

}
