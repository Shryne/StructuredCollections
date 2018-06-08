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

package de.collections.iteration;

import de.collections.list.base.ListOf;
import de.collections.list.base.MutableListOf;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class RangedIterationTest {
    @Test
    public void full() {
        final var expected = new ListOf<>(0, 1, 2, 3, 4, 5);
        final var result = new MutableListOf<>();
        new RangedIteration<>(
                expected,
                (e, i) -> result.add(e),
                expected.size()
        ).apply();
        assertEquals(expected, result);
    }

    @Test
    public void aboveZero() {
        final var data = new ListOf<>(0, 1, 2, 3, 4, 5);
        final var result = new MutableListOf<>();
        new RangedIteration<>(
                data,
                (e, i) -> result.add(e),
                2, data.size()
        ).apply();
        assertEquals(
                new ListOf<>(2, 3, 4, 5),
                result
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void belowZero() {
        final var data = new ListOf<>(0, 2, 3, 1, -2);
        new RangedIteration<>(
                data,
                (e, i) -> fail(),
                -1, data.size()
        ).apply();
    }

    @Test
    public void belowSize() {
        final var data = new ListOf<>(0, 1, 2, 3, 4, 5);
        final var result = new MutableListOf<>();
        new RangedIteration<>(
                data,
                (e, i) -> result.add(e),
                5
        ).apply();
        assertEquals(
                new ListOf<>(0, 1, 2, 3, 4),
                result
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void aboveSize() {
        final var data = new ListOf<>(0, 2, 3, 1, -2);
        new RangedIteration<>(
                data,
                (e, i) -> fail(),
                -1, data.size()
        ).apply();
    }

    @Test
    public void insideBoth() {
        final var data = new ListOf<>(0, 1, 2, 3, 4, 5);
        final var result = new MutableListOf<>();
        new RangedIteration<>(
                data,
                (e, i) -> result.add(e),
                1, 5
        ).apply();
        assertEquals(
                new ListOf<>(1, 2, 3, 4),
                result
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void outsideBoth() {
        final var data = new ListOf<>(0, 1, 2, 3, 4, 5);
        new RangedIteration<>(
                data,
                (e, i) -> fail(),
                -1, data.size() + 1
        ).apply();
    }
}
