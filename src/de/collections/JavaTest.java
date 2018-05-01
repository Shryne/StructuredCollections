package de.collections;

import de.collections.list.ConcatList;
import de.collections.list.IterableList;
import de.collections.list.base.List;
import de.collections.list.base.ListImpl;

import java.util.*;

public class JavaTest {
    public static void main(String[] args) {
        new ArrayList<>(Arrays.asList(1, 2, 3, 4)).addAll(
                Arrays.asList(1, 2, 3, 4)
        );

        var iterableList = new IterableList<>(
                new ConcatList<>(
                        new ConcatList<>(
                                new ListImpl<>(0, 1, 2, 3),
                                new ListImpl<>(4, 5, 6, 7)
                        ),
                        new ListImpl<>(8, 9, 10, 11)
                )
        );

        for (var i : iterableList) {
            System.out.println(i);
        }
    }
}
