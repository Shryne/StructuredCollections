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
package de.indexed.list;


import de.indexed.list.base.ListView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListViewTest {
    @Test(expected = IllegalArgumentException.class)
    public void zeroGetOutOfBoundsAbove() {
        new ListView<>().get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroGetOutOfBoundsBelow() {
        new ListView<>().get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aboveGetOutOfBoundsAbove() {
        var list = new ListView<>(
                2, 4, 5, 2, 450, 209, 32, 5
        );
        list.get(list.size());
    }

    @Test
    public void zeroSize() {
        assertEquals(
                0,
                new ListView<>().size()
        );
    }

    @Test
    public void oneGet() {
        assertEquals(
                5,
                (int) new ListView<>(5).get(0)
        );
    }

    @Test
    public void oneSize() {
        assertEquals(
                1,
                new ListView<>(22).size()
        );
    }

    @Test
    public void zeroEmpty() {
        assertTrue(
                new ListView<>().isEmpty()
        );
    }

    @Test
    public void notEmpty() {
        assertFalse(
                new ListView<>(15).isEmpty()
        );
    }

    @Test
    public void multipleGet() {
        assertEquals(
                22,
                (int) new ListView<>(
                       5, 20, 12, 4, 22, 20, 123, 556
                ).get(4)
        );
    }

    @Test
    public void multipleSize() {
        assertEquals(
                4,
                new ListView<>(5, 3, 7, 2).size()
        );
    }

    @Test
    public void multipleToString() {
        assertEquals(
                "List: [10, 55, 200, 21]",
                new ListView<>(
                        10, 55, 200, 21
                ).toString()
        );
    }
}
