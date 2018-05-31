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

package de.collections.array;

import de.collections.array.base.ArrayOf;
import de.collections.iterable.base.FilteredIterator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * - mutable
 *
 * @param
 * @return
 */
public class IteratorAsArrayTest {
    @Test
    public void zero() {
        assertEquals(
                new ArrayOf<>(),
                new IteratorAsArray<>(
                        new FilteredIterator<>()
                )
        );
    }

    @Test
    public void one() {
        assertEquals(
                new ArrayOf<>("Hey"),
                new IteratorAsArray<>(
                        new FilteredIterator<>("Hey")
                )
        );
    }

    @Test
    public void multiple() {
        assertEquals(
                new ArrayOf<>("A", "B", "C"),
                new IteratorAsArray<>(
                        new FilteredIterator<>("A", "B", "C")
                )
        );
    }
}
