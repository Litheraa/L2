package vehicles.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Wing {
	private final int wingSpan;

	public Wing copyOf() {
		return new Wing(this.wingSpan);
	}
}
