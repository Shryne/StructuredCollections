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
package de.collections.vector;

import de.collections.iterable.base.IterableOf;
import de.collections.list.base.ListOf;
import de.collections.list.base.MutableListOf;
import de.collections.vector.base.MutableVectorOf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MutableVectorTest {
    @Test(expected = IllegalArgumentException.class)
    public void zeroGet() {
        new MutableVectorOf<>().get(0);
    }

    @Test
    public void oneGet() {
        assertEquals(
                25,
                (int) new MutableVectorOf<>(25).get(0)
        );
    }

    @Test
    public void zeroSetZero() {
        var vector =  new MutableVectorOf<>();
        vector.set(0, 25);
        assertEquals(
                1,
                vector.size()
        );
    }

    @Test
    public void zeroSetFartherAway() {
        var vector = new MutableVectorOf<Integer>();
        vector.set(4, 12);
        var list = new MutableListOf<Integer>();
        for (var element : new IterableOf<>(vector)) {
            list.add(element);
        }
        assertEquals(
                new ListOf<>(0, 0, 0, 0, 12),
                list
        );
    }
}
