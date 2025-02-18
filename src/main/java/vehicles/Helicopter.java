package vehicles;

import lombok.Getter;
import lombok.Setter;
import vehicles.parts.Screw;
import vehicles.parts.Wheel;


public class Helicopter extends Vehicle implements Freightable {
	@Getter
	@Setter
	private Screw screw;
	@Getter
	@Setter
	private Wheel wheel;

	public Helicopter(String model) {
		super(model);
	}

	@Override
	public void move() {

	}
}
