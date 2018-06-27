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

import de.indexed.IndexedCollection;

/**
 * A view to a mutable stack.
 * <p>This class is immutable and thread-safe.</p>
 * @see de.indexed.vector.base.Vector
 * @param <T> The type of the elements of the stack.
 */
public final class StackView<T> implements Stack<T> {
    private final Stack<T> stack;

    /**
     * Uses the {@link VectorStack} to create the view.
     * @param ts The elements for the stack.
     */
    public StackView(T... ts) {
        this(new VectorStack<>(ts));
    }

    /**
     * @param stack to create the view on.
     */
    public StackView(MutableStack<T> stack) {
        this.stack = stack;
    }

    @Override
    public T top() {
        return stack.top();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public IndexedCollection<T> elements() {
        return stack.elements();
    }

    @Override
    public boolean equals(Object obj) {
        return stack.equals(obj);
    }

    @Override
    public int hashCode() {
        return stack.hashCode();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
