/**
 * MIT Licence
 * Copyright (c) 2018 Eugen Deutsch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
