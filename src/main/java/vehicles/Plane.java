package vehicles;

import lombok.Getter;
import lombok.Setter;
import vehicles.parts.Screw;
import vehicles.parts.Wheel;
import vehicles.parts.Wing;

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
