package L2.mammals;

import java.util.ArrayList;

public class Water {
	private ArrayList<Swimming> inhabitants = new ArrayList<>();

	public void addInhabitant(Swimming inhabitant) {
		inhabitants.add(inhabitant);
	}

	public void removeInhabitant(Swimming inhabitant) {
		inhabitants.remove(inhabitant);
	}
}
