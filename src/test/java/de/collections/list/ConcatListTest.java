package de.collections.list;

import de.collections.list.base.ListOf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * - mutable
 *
 * @param
 * @return
 */
public class ConcatListTest {
    @Test
    public void testOneToOne() {
        assertEquals(
                55,
                (int) new ConcatList<>(
                        new ListOf<>(55),
                        new ListOf<>(23)
                ).get(0)
        );

        assertEquals(
                23,
                (int) new ConcatList<>(
                        new ListOf<>(55),
                        new ListOf<>(23)
                ).get(1)
        );

        assertEquals(
                2,
                new ConcatList<>(
                        new ListOf<>(55),
                        new ListOf<>(23)
                ).size()
        );
    }
}
