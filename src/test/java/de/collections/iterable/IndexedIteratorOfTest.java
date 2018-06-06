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

package de.collections.iterable;

import de.collections.iterable.base.IndexedIteratorOf;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IndexedIteratorOfTest {
    @Test
    public void zeroHasNext() {
        assertFalse(
                new IndexedIteratorOf<>().hasNext()
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void zeroNext() {
        new IndexedIteratorOf<>().next();
    }

    @Test
    public void zeroNextIndex() {
        assertEquals(
                0,
                new IndexedIteratorOf<>().nextIndex()
        );
    }

    @Test
    public void oneHasNext() {
        final var iterator = new IndexedIteratorOf<>(5);
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void oneNext() {
        assertEquals(
                12,
                (int) new IndexedIteratorOf<>(12).next()
        );
    }

    @Test
    public void oneNextIndex() {
        final var iterator = new IndexedIteratorOf<>(33);
        assertEquals(
                0,
                iterator.nextIndex()
        );
        iterator.next();
        assertEquals(1,
                iterator.nextIndex()
        );
    }

    @Test
    public void multipleHasNext() {
        final var iterator = new IndexedIteratorOf<>(0, 3, 5, 2, 3);
        int counter = 0;
        while (iterator.hasNext()) {
            counter++;
            iterator.next();
        }
        assertEquals(5, counter);
    }

    @Test
    public void multipleNext() {
        final var values = new Integer[] {0, 5, 2, 45, 39, -6};
        final var iterator = new IndexedIteratorOf<>(values);
        for (Integer value : values) {
            assertEquals(value, iterator.next());
        }
    }

    @Test
    public void multipleNextIndex() {
        final var iterator = new IndexedIteratorOf<>(5, 3, 5, -2, 3, 4, 2, 1, 1);
        for (int i = 0; i < 8; i++, iterator.next()) {
            assertEquals(
                    i,
                    iterator.nextIndex()
            );
        }
    }
}
