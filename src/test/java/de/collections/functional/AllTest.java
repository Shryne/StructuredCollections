package de.collections.functional;

import de.collections.IterableOf;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AllTest {
    @Test
    public void zero() {
        assertTrue(
                new All<>(
                        new IterableOf<>(),
                        e -> true
                ).value()
        );

        assertTrue(
                new All<>(
                        new IterableOf<>(),
                        e -> false
                ).value()
        );
    }

    @Test
    public void one() {
        assertTrue(
                new All<>(
                        new IterableOf<>(1),
                        e -> e == 1
                ).value()
        );
    }

    @Test
    public void oneNot() {
        assertTrue(
                new All<>(
                        new IterableOf<>(5),
                        e -> e != 5
                ).value()
        );
    }

    @Test
    public void multiple() {
        assertTrue(
                new All<>(
                        new IterableOf<>(
                                2, 4, 6, 8, 10, 12, 14, 16, 18, 200, 500
                        ),
                        e -> e % 2 == 0
                ).value()
        );
    }

    @Test
    public void multipleFalseLast() {
        assertTrue(
                new All<>(
                        new IterableOf<>(
                                2, 4, 6, 8, 10, 12, 14, 16, 18, 200, 500, 33
                        ),
                        e -> e % 2 == 0
                ).value()
        );
    }
}
