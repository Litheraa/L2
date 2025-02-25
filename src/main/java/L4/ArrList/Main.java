package L4.ArrList;

import L4.Horn;
import L4.HornComparator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OneWayList<Horn> newList = new OneWayList<>(new Horn("smth"));
        System.out.println(newList);
        OneWayList<Horn> newestList = new OneWayList<>(new Horn("ggg"));
        newestList.add(new Horn("isch"));
        System.out.println(newestList);
        newList.add(new Horn("smth2"));
        newList.add(new Horn("fin"), 1);
        System.out.println(newList);
        newList.add(newestList);
        System.out.println(newList);
        OneWayListItem<Horn> string = new OneWayListItem<>(new Horn("line"));
        System.out.println(newestList);
        newestList.add(string, 2);
        System.out.println(newestList);
        OneWayList<Horn> cloneList = newestList.clone();
        newestList.setHead(new Horn("111"));
        System.out.println(cloneList);
        System.out.println(newList);
        System.out.println(newestList.setData(new Horn("!!!"), 0));
        System.out.println(newestList);
        newestList.delete();
        System.out.println(newestList);
        newestList.delete(1);
        System.out.println(newestList);
        System.out.println(newestList.delete(new Horn("888")));
        System.out.println(newestList);
        ArrayList<Horn> strings = new ArrayList<>();
        strings.add(new Horn("мишень"));
        strings.add(new Horn("рог"));
        strings.add(new Horn("арбуз"));
        System.out.println(strings);
        Gen gen = new Gen(strings);
        System.out.println(Gen.sort(new HornComparator()));
    }
}
