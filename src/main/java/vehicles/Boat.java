package vehicles;

import lombok.Getter;
import lombok.Setter;
import vehicles.parts.Screw;

public class Boat extends Vehicle implements Freightable{
	@Getter
	@Setter
	private Screw screw;

	public Boat(String model) {
		super(model);
	}

	@Override
	public void move() {
	}
}
