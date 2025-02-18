package mammals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Mammal extends Animal{
	private final Spine spine;
}
