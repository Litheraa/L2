package L4.ArrList;

import L4.Horn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Gen {
	private final static ArrayList<Horn> arrList = new ArrayList<>();

	public Gen(Collection<? extends Horn> collection) {
		arrList.addAll(collection);
	}

	public static ArrayList<Horn> sort(Comparator<? super Horn> comparator) {
		return new ArrayList<>(arrList.stream().sorted(comparator).toList());
	}

	@Override
	public String toString() {
		return "gen of:" + arrList;
	}
}
