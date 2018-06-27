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

import de.indexed.vector.base.VectorView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatVectorTest {
    @Test
    public void zeroZeroSize() {
        assertEquals(
                0,
                new ConcatVector<>(
                        new VectorView<>(),
                        new VectorView<>()
                ).size()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroZeroGet() {
        new ConcatVector<>(
                new VectorView<>(),
                new VectorView<>()
        ).get(0);
    }

    @Test
    public void zeroSetZero() {
        final var vector = new ConcatVector<Integer>(
                new VectorView<>(),
                new VectorView<>()
        );
        vector.set(vector.size(), 15);
        assertEquals(
                15,
                (int) vector.get(0)
        );
    }

    @Test
    public void zeroSetFartherAway() {
        final var vector = new ConcatVector<Integer>(
                new VectorView<>(),
                new VectorView<>()
        );
        vector.set(7, 33);
        assertEquals(
                new VectorView<>(
                        null, null, null, null, null, null, null, 33
                ),
                vector
        );
    }

    @Test
    public void zeroOneGet() {
        assertEquals(
                523,
                (int) new ConcatVector<>(
                        new VectorView<>(),
                        new VectorView<>(523)
                ).get(0)
        );
    }

    @Test
    public void zeroOneSize() {
        assertEquals(
                1,
                new ConcatVector<>(
                        new VectorView<>(),
                        new VectorView<>(75)
                ).size()
        );
    }

    @Test
    public void multipleSize() {
        assertEquals(
                13,
                new ConcatVector<>(
                        new VectorView<>(23, 43, 132, 19, -23, 43, 0, -2),
                        new VectorView<>(0, 0, 0, -32, 2320)
                ).size()
        );
    }

    @Test
    public void multipleGet() {
        assertEquals(
                new VectorView<>(
                        23, 43, 132, 19, -23, 43, 0, -2, 0, 0, 0, -32, 2320
                ),
                new ConcatVector<>(
                        new VectorView<>(23, 43, 132, 19, -23, 43, 0, -2),
                        new VectorView<>(0, 0, 0, -32, 2320)
                )
        );
    }
}
