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

package de.collections.iterable;

import de.collections.array.base.ArrayOf;
import de.collections.iterable.base.IterableOf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeOfTest {
    @Test
    public void empty() {
        assertEquals(
                new IterableOf<>(),
                new RangeOf<>(
                        new ArrayOf<>()
                )
        );
    }

    @Test
    public void multipleBelowBounds() {
        assertEquals(
                new IterableOf<>(22, 23, 24, 70, 82),
                new RangeOf<>(
                        new ArrayOf<>(22, 23, 24, 70, 82),
                        -5
                )
        );
    }

    @Test
    public void multipleAboveBounds() {
        assertEquals(
                new IterableOf<>(52, 53, 54),
                new RangeOf<>(
                        new ArrayOf<>(52, 53, 54),
                        0, 20
                )
        );
    }

    @Test
    public void multipleInBounds() {
        assertEquals(
                new IterableOf<>(-1, -2, -3, -4),
                new RangeOf<>(
                        new ArrayOf<>(15, 23, 5434, -1, -2, -3, -4, 54, 23, 439),
                        3, 7
                )
        );
    }

    @Test
    public void multipleAll() {
        assertEquals(
                new IterableOf<>(1, 2, 3, 4),
                new RangeOf<>(
                        new ArrayOf<>(1, 2, 3, 4),
                        0, 4
                )
        );
    }

    @Test
    public void multipleStringInBounds() {
        assertEquals(
                "1, 2, 3, 4, 5",
                new RangeOf<>(
                        new ArrayOf<>(5, 23, 34, 1, 2, 3, 4, 5, 49, 20),
                        3, 8
                ).toString()
        );
    }
}
