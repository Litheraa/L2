package mammals;

import lombok.Getter;
import lombok.Setter;

public class Bear extends Mammal{
	@Setter
	@Getter
	private Fur fur;

	public Bear(Spine spine, Fur fur) {
		super(spine);
		this.fur = fur;
	}
}
