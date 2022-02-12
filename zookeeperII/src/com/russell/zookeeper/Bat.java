package com.russell.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		this.setEnergyUp(200);
	}
	public void fly() {
		this.setEnergyDown(50);
		System.out.println("flying! -50 energy");
	}
	public void eatHumans() {
		this.setEnergyUp(25);
		System.out.println("Eating + 25 energy");
	}
	public void attackTown() {
		this.setEnergyDown(100);
		System.out.println("ATTACK! - 100 energy");
	}

}
