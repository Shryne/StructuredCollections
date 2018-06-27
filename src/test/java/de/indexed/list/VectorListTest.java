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


import de.collections.iterable.base.IterableOf;
import de.indexed.list.base.ListView;
import de.indexed.list.base.MutableList;
import de.indexed.list.base.VectorList;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VectorListTest {
    @Test
    public void zeroAdd() {
        final MutableList<Integer> list = new VectorList<>(10);
        assertEquals(
                10,
                (int) list.get(0)
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void zeroRemove() {
        new VectorList<>().removeLast();
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroRemoveBelowBounds() {
        new VectorList<>().remove(-1);
    }

    @Test
    public void oneRemove() {
        final MutableList<Integer> list = new VectorList<>(20);
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void oneAdd() {
        final var element = -22;
        final var list = new VectorList<>(element);
        assertEquals(element, (int) list.get(0));
    }

    @Test
    public void twoAdds() {
        final var result = new ListView<>(4, 2);
        final var list = new VectorList<Integer>();
        for (Integer element : new IterableOf<>(result)) {
            list.add(element);
        }
        assertEquals(result, list);
    }

    @Test
    public void multipleAdds() {
        final var result = new ListView<>(5, 2, 3, 49, 12, 48, 120);
        final var list = new VectorList<Integer>();
        for (Integer element : new IterableOf<>(result)) {
            list.add(element);
        }
        assertEquals(result, list);
    }
}
