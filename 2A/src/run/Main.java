package run;

import action.Task;
import create.SetCreator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

/*
     8. С использованием множества выполнить попарное суммирование
        произвольного конечного ряда чисел по следующим правилам:
        на первом этапе суммируются попарно рядом стоящие числа,
        на втором этапе суммируются результаты первого этапа и т.д.
        до тех пор, пока не останется одно число.
 */

public class Main {
    public static final int n = 7;

    public static void main(String[] args) {
        Set<Integer> originalSet = SetCreator.create(n);
        LinkedList<Set<Integer>> sets = Task.summarize(originalSet);

        for (Set<Integer> set: sets) {
            System.out.println(Arrays.toString(set.toArray()));
        }
    }
}
