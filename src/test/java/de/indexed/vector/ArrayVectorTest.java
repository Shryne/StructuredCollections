/**
 * MIT Licence
 * Copyright (c) 2018 Eugen Deutsch
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.indexed.vector;

import de.collections.iterable.base.IterableOf;
import de.indexed.vector.base.ArrayVector;
import de.indexed.vector.base.VectorView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayVectorTest {
    @Test
    public void zeroSetZero() {
        final var vector = new ArrayVector<>();
        vector.set(0, 25);
        assertEquals(
                1,
                vector.size()
        );
    }

    @Test
    public void zeroSetFartherAway() {
        final var vector = new ArrayVector<Integer>();
        vector.set(4, 12);
        assertEquals(
                new IterableOf<>(null, null, null, null, 12),
                new IterableOf<>(vector)
        );
    }

    @Test
    public void someShrink() {
        final var vector = new ArrayVector<>(0, 1, 2, 3, 4, 5);
        vector.shrink(4);
        assertEquals(
                new VectorView<>(0, 1, 2, 3),
                vector
        );
    }
}
