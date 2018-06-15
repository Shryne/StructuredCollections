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

public class IndexedIterationOfTest {
    @Test
    public void zero() {
        new IndexedIterationOf<>(
                new ListOf<>(),
                (e, i) -> fail()
        ).apply();
    }

    @Test
    public void one() {
        final var expected = new ListOf<>(6);
        final var result = new MutableListOf<Integer>();
        new IndexedIterationOf<>(
                expected,
                (e, i) -> result.add(e)
        ).apply();
        assertEquals(
                expected,
                result
        );
    }

    @Test
    public void two() {
        final var expected = new ListOf<>(6, -32);
        final var result = new MutableListOf<Integer>();
        new IndexedIterationOf<>(
                expected,
                (e, i) -> result.add(e)
        ).apply();
        assertEquals(
                expected,
                result
        );
    }

    @Test
    public void multipleIndex() {
        final var expected = new ListOf<>(0, 1, 2, 3, 4, 5, 6, 7, 8);
        final var result = new MutableListOf<Integer>();
        new IndexedIterationOf<>(
                expected,
                (e, i) -> result.add(i)
        ).apply();
        assertEquals(
                expected,
                result
        );
    }

    @Test
    public void multiple() {
        final var expected = new ListOf<>(6, -4, 2, 39, 234, 548);
        final var result = new MutableListOf<Integer>();
        new IndexedIterationOf<>(
                expected,
                (e, i) -> result.add(e)
        ).apply();
        assertEquals(
                expected,
                result
        );
    }
}
