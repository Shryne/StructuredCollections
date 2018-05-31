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
package de.collections.iterable;

import de.collections.iterable.base.IterableOf;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class IterableOfTest {
    @Test
    public void zeroIteration() {
        for (Object ignored : new IterableOf<>()) {
            fail();
        }
    }

    @Test
    public void zeroEquals() {
        //noinspection unchecked
        assertEquals(
                new IterableOf<>(),
                new IterableOf<>()
        );
    }

    @Test
    public void oneEquals() {
        assertEquals(
                new IterableOf<>(5),
                new IterableOf<>(5)
        );
    }

    @Test
    public void oneEqualsNot() {
        assertThat(
                new IterableOf<>(3),
                not(equalTo(new IterableOf<>(2)))
        );
    }

    @Test
    public void multipleEquals() {
        assertEquals(
                new IterableOf<>(0, 5, 22, 3),
                new IterableOf<>(0, 5, 22, 3)
        );
    }

    @Test
    public void multipleEqualsNot() {
        assertThat(
                new IterableOf<>(1, 2, 3, 4, 5, 6, 7, 8),
                not(equalTo(new IterableOf<>(1, 2, 3, 4, 6, 7, 8, 5)))
        );
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
