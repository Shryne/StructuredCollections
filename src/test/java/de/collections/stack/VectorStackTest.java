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

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class VectorStackTest {
    @Test
    public void someAdd() {
        final var stack = new VectorStack<>(0, 1, 2, 3, 4);
        stack.add(5);
        assertEquals(
                new StackView<>(0, 1, 2, 3, 4, 5),
                stack
        );
    }

    @Test
    public void somePop() {
        final var stack = new VectorStack<>(0, 1, 2, 3, 4);
        assertEquals(
                4,
                (int) stack.pop()
        );
        assertEquals(
                new StackView<>(0, 1, 2, 3),
                stack
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyPop() {
        new VectorStack<>().pop();
    }

    @Test
    public void onePop() {
        final var stack = new VectorStack<>(1);
        assertEquals(1, (int) stack.pop());
        assertEquals(
                new VectorStack<>(),
                stack
        );
    }
}
