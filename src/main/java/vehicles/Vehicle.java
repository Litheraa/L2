package vehicles;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Vehicle {
	private String model;
	public abstract void move();
}
