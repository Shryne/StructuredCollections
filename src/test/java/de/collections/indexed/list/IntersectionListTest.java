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

package de.collections.indexed.list;

import de.collections.indexed.list.base.ListView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntersectionListTest {
    @Test
    public void empties() {
        assertEquals(
                new ListView<>(),
                new IntersectionList<>(
                        new ListView<>(),
                        new ListView<>()
                )
        );
    }

    @Test
    public void different() {
        assertEquals(
                new ListView<>(),
                new IntersectionList<>(
                        new ListView<>(0, 2, 5, 12, 39),
                        new ListView<>(-3, -5, -23, -5, -23, -54)
                )
        );
    }

    @Test
    public void oneSame() {
        assertEquals(
                new ListView<>(0),
                new IntersectionList<>(
                        new ListView<>(2, 4, 6, 2, 0, 2, 9, 38),
                        new ListView<>(-4, -23, -4, 0)
                )
        );
    }

    @Test
    public void multipleSame() {
        assertEquals(
                new ListView<>(5, 2, 3),
                new IntersectionList<>(
                        new ListView<>(5, 49, 230, 2, 483, 3),
                        new ListView<>(17, 5, 328, 2, 3834, 4398, 439, 3)
                )
        );
    }

    @Test
    public void allSame() {
        assertEquals(
                new ListView<>(4, 29, 32),
                new IntersectionList<>(
                        new ListView<>(4, 29, 32),
                        new ListView<>(4, 29, 32)
                )
        );
    }
}
