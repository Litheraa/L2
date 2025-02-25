package L2.mammals;

import lombok.Getter;
import lombok.Setter;

public class Cat extends Mammal{
	@Getter
	@Setter
	private Fur fur;

	public Cat(Spine spine) {
		super(spine);
	}
}
