package L2.vehicles;

import lombok.Getter;
import lombok.Setter;
import L2.vehicles.parts.Wheel;

public class Taxi extends Vehicle {
	@Setter
	@Getter
	private Wheel wheel;

	public Taxi(String model) {
		super(model);
	}

	@Override
	public void move() {

	}
}
