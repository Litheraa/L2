package vehicles;

import lombok.Getter;
import lombok.Setter;
import vehicles.parts.Screw;

public class Tanker extends Vehicle implements Freightable{
	@Setter
	@Getter
	private Screw screw;

	public Tanker(String model) {
		super(model);
	}

	@Override
	public void move() {

	}
}
