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

package de.collections.stack;

import de.collections.iterable.base.IterableOf;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StackViewTest {
    @Test
    public void someEquals() {
        assertEquals(
                new StackView<>(1, 2, 3, 4, 5, 6),
                new StackView<>(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    public void someEqualsFalse() {
        assertNotEquals(
                new StackView<>(1, 2, 3, 4, 5),
                new StackView<>(2, 3, 4, 5, 1)
        );
    }

    @Test
    public void someToString() {
        assertEquals(
                "Stack: [5, 2, 3, 4, 2]",
                new StackView<>(5, 2, 3, 4, 2).toString()
        );
    }

    @Test
    public void someTop() {
        assertEquals(
                5,
                (int) new StackView<>(0, 1, 2, 3, 4, 5).top()
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyTop() {
        new StackView<>().top();
    }

    @Test
    public void oneTop() {
        assertEquals(
                1,
                (int) new StackView<>(1).top()
        );
    }

    @Test
    public void someElements() {
        assertEquals(
                new IterableOf<>(
                        0, 1, 2, 3, 4
                ),
                new IterableOf<>(
                        new StackView<>(0, 1, 2, 3, 4).elements()
                )
        );
    }
}
