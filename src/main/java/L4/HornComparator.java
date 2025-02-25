package L4;

import java.util.Comparator;

public class HornComparator implements Comparator<Horn> {
	@Override
	public int compare(Horn o1, Horn o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
