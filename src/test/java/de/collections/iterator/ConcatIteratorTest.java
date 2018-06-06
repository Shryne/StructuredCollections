/*
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
package de.collections.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ConcatIteratorTest {
    @Test(expected = NoSuchElementException.class)
    public void zero() {
        new ConcatIterator<>(
                new FilteredIterator<>(),
                new FilteredIterator<>()
        ).next();
    }

    @Test
    public void one() {
        assertEquals(
                5,
                (int) new ConcatIterator<>(
                        new FilteredIterator<>(5),
                        new FilteredIterator<>()
                ).next()
        );
    }

    @Test
    public void multiple() {
        final List<Integer> list = new ArrayList<>();
        final var iterator = new ConcatIterator<>(
                new FilteredIterator<>(1, 2, 3, 4, 5),
                new FilteredIterator<>(5, 2, 3, 59)
        );
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        assertEquals(
                Arrays.asList(1, 2, 3, 4, 5, 5, 2, 3, 59),
                list
        );
    }
}
