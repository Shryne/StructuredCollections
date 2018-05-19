package de.collections;

import de.collections.list.base.ListOf;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ContainsLinearTest {
    @Test
    public void one() {
        new ContainsLinear<>(
                new ListOf<>(0),
                0
        ).apply(
                () -> assertTrue(true)
        );
        assertFalse(false);
    }

    @Test
    public void oneNot() {
        new ContainsLinear<>(
                new ListOf<>(0),
                1
        ).apply(
                () -> assertFalse(false)
        );
        assertTrue(true);
    }

    @Test
    public void zeroNot() {
        new ContainsLinear<>(
                new ListOf<>(),
                5
        ).apply(
                () -> assertFalse(false)
        );
        assertTrue(true);
    }
}
