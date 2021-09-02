package create;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetCreator {
    public static final int min = -5;
    public static final int max = 5;

    public static Set<Integer> create(int n) {
        Set<Integer> set = new LinkedHashSet<Integer>();

        if (n > max - min + 1) {
            n = max - min + 1;
        }

        while (set.size() < n) {
            set.add((int) Math.round(Math.random() * (max - min) + min));
        }

        return set;
    }
}
