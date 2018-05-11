package de.collections;

import de.collections.list.base.ListOf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndexOfTests {
    @Test
    public void testOneElement() {
        assertEquals(
                0,
                new IndexOf<>(
                        new IterableOf<>(
                                new ListOf<>(
                                        5
                                )
                        ),
                        5
                ).intValue()
        );
    }
}
