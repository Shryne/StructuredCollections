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
package de.collections.iterable;

import de.indexed.array.IteratorAsArray;
import de.indexed.array.base.ArrayOf;
import de.collections.iterable.base.IterableOf;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class ConcatIterableTest {
    @Test
    public void zero() {
        for (Object ignored : new ConcatIterable<>(
                new IterableOf<>(),
                new IterableOf<>()
        )) {
            fail();
        }
    }

    @Test
    public void one() {
        final List<Integer> list = new ArrayList<>();
        for (Integer element : new ConcatIterable<>(
                new IterableOf<>(),
                new IterableOf<>(15)
        )) {
            list.add(element);
        }
        assertEquals(
                Collections.singletonList(15),
                list
        );
    }

    @Test
    public void multiple() {
        final List<Integer> list = new ArrayList<>();
        for (Integer element : new ConcatIterable<>(
                new IterableOf<>(3, 6, 209, 2),
                new IterableOf<>(7, 23)
        )) {
            list.add(element);
        }
        assertEquals(
                Arrays.asList(3, 6, 209, 2, 7, 23),
                list
        );
    }

    @Test
    public void multipleAsArray() {
        assertEquals(
                new ArrayOf<>(1, 6, 23, 94, 3, 59, 2, 6),
                new IteratorAsArray<>(
                        new ConcatIterable<>(
                                new IterableOf<>(1, 6, 23, 94),
                                new IterableOf<>(3, 59, 2, 6)
                        ).iterator()
                )
        );
    }
}
