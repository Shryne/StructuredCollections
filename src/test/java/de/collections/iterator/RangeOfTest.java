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

import de.indexed.array.base.ArrayOf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RangeOfTest {
    @Test
    public void emptyHasNext() {
        assertFalse(
                new RangeOf<>(
                        new ArrayOf<>()
                ).hasNext()
        );
    }

    @Test
    public void multipleBelowBoundsNext() {
        final var elements = new Integer[] {22, 23, 24, 70, 82};
        final var iterator = new RangeOf<>(
                new ArrayOf<>(elements),
                -5
        );
        for (Integer element : elements) {
            assertEquals(element, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void multipleAboveBoundsNext() {
        final var elements = new Integer[] {52, 53, 54};
        final var iterator = new RangeOf<>(
                new ArrayOf<>(elements),
                0, 20
        );
        for (Integer element : elements) {
            assertEquals(element, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void multipleInBoundsNext() {
        final var elements = new Integer[] {15, 23, 5434, -1, -2, -3, -4, 54, 23, 439};
        final var start = 3;
        final var end = 7;
        final var iterator = new RangeOf<>(
                new ArrayOf<>(elements),
                start, end

        );
        for (int i = start; i < end; i++) {
            assertEquals(elements[i], iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void multipleAllNext() {
        final var elements = new Integer[] {1, 2, 3, 4};
        final var iterator = new RangeOf<>(
                new ArrayOf<>(elements),
                0, 4
        );
        for (Integer element : elements) {
            assertEquals(element, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }
}
