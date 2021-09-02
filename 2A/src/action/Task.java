package action;

import java.util.*;

public class Task {
    public static LinkedList<Set<Integer>> summarize(Set<Integer> set) {
        LinkedList<Set<Integer>> list = new LinkedList<Set<Integer>>();
        list.add(set);

        Set<Integer> set1 = new LinkedHashSet<Integer>(set);

        do {
            Set<Integer> set2 = new LinkedHashSet<Integer>();
            Iterator<Integer> iterator = set1.iterator();
            Integer x = iterator.next();

            while (iterator.hasNext()) {
                Integer y = iterator.next();
                set2.add(x + y);
                x = y;
            }

            set1.removeAll(set1);
            set1.addAll(set2);

            list.add(set2);
        } while (set1.size() != 1);

        return list;
    }
}
