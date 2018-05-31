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
import de.collections.array.base.MutableArrayOf;
import de.collections.iterable.base.IterableOf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MutableArrayOfTest {
    @Test(expected = IllegalArgumentException.class)
    public void zeroSetAbove() {
        new MutableArrayOf<>().set(0, 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBelow() {
        new MutableArrayOf<>(0, 3, 59, 20, -3).set(-1, 15);
    }

    @Test
    public void oneSet() {
        final var list = new MutableArrayOf<>(15);
        list.set(0, 22);
        assertEquals(
                new ArrayOf<>(22),
                list
        );
    }

    @Test
    public void multipleSetZero() {
        final var list = new MutableArrayOf<>(0, 1, 2, 3, 4);
        list.set(1, new IterableOf<>());
        assertEquals(
                new ArrayOf<>(0, 1, 2, 3, 4),
                list
        );
    }

    @Test
    public void multipleSet() {
        final var list = new MutableArrayOf<>(0, 1, 2, 3, 4);
        list.set(1, 2);
        assertEquals(
                new ArrayOf<>(0, 2, 2, 3, 4),
                list
        );
    }

    @Test
    public void multipleSetMultiple() {
        final var list = new MutableArrayOf<>(0, 1, 2, 3, 4);
        list.set(1, new IterableOf<>(5, 4, 3));
        assertEquals(
                new ArrayOf<>(0, 5, 4, 3, 4),
                list
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void multipleSetOutOfBounds() {
        new MutableArrayOf<>(0, 1, 2).set(
                0,
                new IterableOf<>(1, 2, 3, 4, 5)
        );
    }

    @Test
    public void zeroResize() {
        assertEquals(
                new ArrayOf<>(null, null, null, null, null, null, null, null, null, null),
                new MutableArrayOf<>().resize(10)
        );
    }

    @Test
    public void multipleResizeUp() {
        assertEquals(
                new ArrayOf<>(1, 2, 3, 4, 5, null, null, null, null),
                new MutableArrayOf<>(1, 2, 3, 4, 5).resize(9)
        );
    }

    @Test
    public void multipleResizeDown() {
        assertEquals(
                new ArrayOf<>(5, 23, 59, 23, 458, 23),
                new MutableArrayOf<>(5, 23, 59, 23, 458, 23, 3, 59, 23, 1239).resize(6)
        );
    }

    @Test
    public void multipleResizeSame() {
        assertEquals(
                new ArrayOf<>(5, 4, 3, 2, 1),
                new MutableArrayOf<>(5, 4, 3, 2, 1).resize(5)
        );
    }
}
