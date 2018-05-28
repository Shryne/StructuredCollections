package de.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void oneIteration() {
        var elements = new Integer[]{5};
        var list = new ArrayList<Integer>();
        for (int i : new IterableOf<>(elements)) {
            list.add(i);
        }
        assertEquals(
                Arrays.asList(elements),
                list
        );
    }

    @Test
    public void multipleIteration() {
        var elements = new Integer[]{1, 2, 3, 4, 5};
        var list = new ArrayList<Integer>();
        for (int i : new IterableOf<>(elements)) {
            list.add(i);
        }
        assertEquals(
                Arrays.asList(elements),
                list
        );
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
