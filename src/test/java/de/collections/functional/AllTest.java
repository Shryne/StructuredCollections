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
package de.collections.functional;

import de.collections.iterable.base.IterableOf;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class AllTest {
    @Test
    public void zero() {
        assertTrue(
                new All<>(
                        new IterableOf<>(),
                        e -> true
                ).value()
        );

        assertTrue(
                new All<>(
                        new IterableOf<>(),
                        e -> false
                ).value()
        );
    }

    @Test
    public void one() {
        assertTrue(
                new All<>(
                        new IterableOf<>(1),
                        e -> e == 1
                ).value()
        );
    }

    @Test
    public void oneNot() {
        assertFalse(
                new All<>(
                        new IterableOf<>(5),
                        e -> e != 5
                ).value()
        );
    }

    @Test
    public void multiple() {
        assertTrue(
                new All<>(
                        new IterableOf<>(
                                2, 4, 6, 8, 10, 12, 14, 16, 18, 200, 500
                        ),
                        e -> e % 2 == 0
                ).value()
        );
    }

    @Test
    public void multipleFalseLast() {
        assertFalse(
                new All<>(
                        new IterableOf<>(
                                2, 4, 6, 8, 10, 12, 14, 16, 18, 200, 500, 33
                        ),
                        e -> e % 2 == 0
                ).value()
        );
    }
}
