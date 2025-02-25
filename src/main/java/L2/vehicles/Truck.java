package L2.vehicles;

import lombok.Getter;
import lombok.Setter;
import L2.vehicles.parts.Wheel;

public class Truck extends Vehicle implements Freightable{
	@Setter
	@Getter
	private Wheel wheel;

	public Truck(String model) {
		super(model);
	}

	@Override
	public void move() {
	}
}
