package de.collections;

import de.collections.list.ConcatList;
import de.collections.list.IterableList;
import de.collections.list.base.List;

public class JavaTest {
    public static void main(String[] args) {
        var iterableList = new IterableList<>(
                new ConcatList<>(
                        new List<>(0, 1, 2, 3),
                        new List<>(4, 5, 6, 7)
                )
        );

        for (var i : iterableList) {
            System.out.println(i);
        }
    }
}
