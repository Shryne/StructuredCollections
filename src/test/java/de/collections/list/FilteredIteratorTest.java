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
package de.collections.list;

import de.collections.iterable.FilteredIterator;
import de.collections.list.base.ListOf;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FilteredIteratorTest {
    @Test
    public void zeroFirstHasNextNot() {
        assertFalse(
                new FilteredIterator<>().hasNext()
        );
    }

    @Test
    public void oneFirstHasNext() {
        assertTrue(
                new FilteredIterator<>(5).hasNext()
        );
    }

    @Test
    public void oneFirstNext() {
        assertEquals(
                22,
                (int) new FilteredIterator<>(22).next()
        );
    }

    @Test
    public void multipleFalseFilterHasNext() {
        assertFalse(
                new FilteredIterator<>(
                        new ListOf<>(0, 1, 2, 3, 4, 5),
                        element -> false
                ).hasNext()
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void zeroOutOfBoundsNext() {
        new FilteredIterator<>().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void multipleOutOfBoundsNext() {
        final var iterator = new FilteredIterator<>(1, 2, 3, 4, 5);
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }
}
