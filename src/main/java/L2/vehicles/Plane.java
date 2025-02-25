package L2.vehicles;

import lombok.Getter;
import lombok.Setter;
import L2.vehicles.parts.Screw;
import L2.vehicles.parts.Wheel;
import L2.vehicles.parts.Wing;

public class Plane extends Vehicle implements Freightable{
	private final Wing wings;
	@Getter
	@Setter
	private Wheel wheel;
	@Getter
	@Setter
	private Screw screw;

	public Plane(String model, Wing wings) {
		super(model);
		this.wings = wings;
	}

	public Wing getWings() {
		return wings.copyOf();
	}

	@Override
	public void move() {

	}
}
