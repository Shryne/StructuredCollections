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

import de.collections.indexed.WithSize;
import de.collections.indexed.IndexedCollection;

/**
 * A stack is a "first in, last out" collection. This interface offers no mutable operations.
 * @param <T> The type of the elements of the stack.
 */
public interface Stack<T> extends WithSize {
    /**
     * @return The top element / first element of the stack without deleting it from the stack.
     */
    T top();

    /**
     * @return A view on the elements. By using this, one can create an Iterator and iterate through the elements of the
     * stack.
     */
    IndexedCollection<T> elements();
}