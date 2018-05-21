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
}
