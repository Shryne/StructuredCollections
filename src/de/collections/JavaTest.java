package de.collections;

import de.collections.list.ConcatList;
import de.collections.list.base.ListOf;
import de.collections.list.Iterable;

public class JavaTest {
    public static void main(String[] args) {
        var iterableList = new Iterable<>(
                new ConcatList<>(
                        new ConcatList<>(
                                new ListOf<>(0, 1, 2, 3),
                                new ListOf<>(4, 5, 6, 7)
                        ),
                        new ListOf<>(8, 9, 10, 11)
                )
        );

        for (var i : iterableList) {
            System.out.println(i);
        }
    }
}
