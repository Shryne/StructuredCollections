package de.collections;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class IterableOfTest {
    @Test
    public void zero() {
        for (Object ignored : new IterableOf<>()) {
            fail();
        }
    }

    @Test
    public void zeroString() {
        assertEquals("", new IterableOf<>().toString());
    }

    @Test
    public void oneString() {
        assertEquals("5", new IterableOf<>(5).toString());
    }

    @Test
    public void multipleString() {
        assertEquals(
                "1, 2, 3, 4, 5",
                new IterableOf<>(1, 2, 3, 4, 5).toString()
        );
    }
}
