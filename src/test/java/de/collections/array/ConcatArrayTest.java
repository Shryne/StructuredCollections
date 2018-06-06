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
import de.collections.iterator.FilteredIterator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatArrayTest {
    @Test
    public void zeroZero() {
        assertEquals(
                new ArrayOf<>(),
                new ConcatArray<>(
                        new ArrayOf<>(),
                        new ArrayOf<>()
                )
        );
    }

    @Test
    public void oneZero() {
        assertEquals(
                new ArrayOf<>(15),
                new ConcatArray<>(
                        new ArrayOf<>(15),
                        new ArrayOf<>()
                )
        );
    }

    @Test
    public void zeroOne() {
        assertEquals(
                new ArrayOf<>(15),
                new ConcatArray<>(
                        new ArrayOf<>(),
                        new ArrayOf<>(15)
                )
        );
    }

    @Test
    public void oneOne() {
        assertEquals(
                new ArrayOf<>(2, -3),
                new ConcatArray<>(
                        new ArrayOf<>(2),
                        new ArrayOf<>(-3)
                )
        );
    }

    @Test
    public void multiple() {
        assertEquals(
                new ArrayOf<>(0, 5, 23, -3, 54, 5, 5),
                new ConcatArray<>(
                        new ArrayOf<>(0, 5, 23),
                        new IteratorAsArray<>(
                                new FilteredIterator<>(-3, 54, 5, 5)
                        )
                )
        );
    }
}
