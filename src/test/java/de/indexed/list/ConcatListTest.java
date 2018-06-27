/**
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
package de.indexed.list;

import de.indexed.list.base.ListView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatListTest {
    @Test
    public void OneZeroGet() {
        assertEquals(
                12,
                (int) new ConcatList<>(
                        new ListView<>(12),
                        new ListView<>()
                ).get(0)
        );
    }

    @Test
    public void OneZeroSize() {
        assertEquals(
                1,
                new ConcatList<>(
                        new ListView<>(12),
                        new ListView<>()
                ).size()
        );
    }

    @Test
    public void ZeroOneGet() {
        assertEquals(
                5,
                (int) new ConcatList<>(
                        new ListView<>(),
                        new ListView<>(5)
                ).get(0)
        );
    }

    @Test
    public void ZeroOneSize() {
        assertEquals(
                1,
                new ConcatList<>(
                        new ListView<>(),
                        new ListView<>(2)
                ).size()
        );
    }

    @Test
    public void OneOneSize() {
        assertEquals(
                2,
                new ConcatList<>(
                        new ListView<>(55),
                        new ListView<>(21)
                ).size()
        );
    }

    @Test
    public void OneOneGet() {
        final var list = new ConcatList<>(
                new ListView<>(22),
                new ListView<>(-42)
        );
        assertEquals(
                22,
                (int) list.get(0)
        );
        assertEquals(
                -42,
                (int) list.get(1)
        );
    }

    @Test
    public void MultipleToString() {
        assertEquals(
                "List: [66, 22, 14, 4, 2]",
                new ConcatList<>(
                        new ListView<>(66, 22, 14),
                        new ListView<>(4, 2)
                ).toString()
        );
    }
}
