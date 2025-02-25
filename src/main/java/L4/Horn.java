package L4;

import lombok.Getter;

public class Horn {
	@Getter
	private final String name;

	public Horn(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Horn)) return false;
		return name.equals(((Horn)obj).getName());
	}
}

