package com.russell.zookeeper;

public class Mammal {
	private int energy;
	public Mammal() {
		this.energy = 100;
	}
	public int displayEnergy() {
		System.out.println(this.energy + " energy level");
		return this.energy;
	}
	public void setEnergyUp(int amount) {
		this.energy = this.energy + amount;
	}
	public void setEnergyDown(int amount) {
		this.energy = this.energy - amount;
	}

}
