package de.collections.list;

import de.collections.list.base.ListOf;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FilteredIteratorTest {
    @Test
    public void zeroFirstHasNextNot() {
        assertFalse(
                new FilteredIterator<>(
                        new ListOf<>()
                ).hasNext()
        );
    }

    @Test
    public void oneFirstHasNext() {
        assertTrue(
                new FilteredIterator<>(
                        new ListOf<>(5)
                ).hasNext()
        );
    }

    @Test
    public void oneFirstNext() {
        assertEquals(
                22,
                (int) new FilteredIterator<>(
                        new ListOf<>(22)
                ).next()
        );
    }

    @Test
    public void multipleFalseFilterHasNext() {
        assertFalse(
                new FilteredIterator<>(
                        new ListOf<>(0, 1, 2, 3, 4, 5),
                        element -> false
                ).hasNext()
        );
    }
}
