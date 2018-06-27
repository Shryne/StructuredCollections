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
import de.collections.indexed.IndexedCollection;
import de.collections.indexed.vector.base.MutableVector;
import de.collections.indexed.vector.base.ArrayVector;

import java.util.NoSuchElementException;

/**
 * A stack based on a vector.
 * <p>This class is mutable and not thread-safe.</p>
 * @param <T> The type of the elements of the stack.
 */
public final class VectorStack<T> implements MutableStack<T> {
    private final MutableVector<T> vector;

    /**
     * Uses a {@link MutableVector} as a base.
     * @param ts the elements for the stack.
     */
    public VectorStack(T... ts) {
        this(new ArrayVector<>(ts));
    }

    /**
     * @param vector to base the stack on.
     */
    public VectorStack(MutableVector<T> vector) {
        this.vector = vector;
    }

    /**
     * @throws NoSuchElementException if the stack is empty.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "No elements to be popped. Stack is empty."
            );
        }
        final T element = vector.last();
        vector.shrink(size() - 1);
        return element;
    }

    @Override
    public void add(T element) {
        vector.set(size(), element);
    }

    @Override
    public T top() {
        if (vector.isEmpty()) {
            throw new NoSuchElementException(
                    "Top can't be used, if the stack has no elements. Use isEmpty to check this"
            );
        }
        return vector.last();
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public IndexedCollection<T> elements() {
        return vector;
    }

    /**
     * It is equal only to other stacks.
     * @see Stack
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stack)) {
            return false;
        }
        //noinspection unchecked
        return new IterableOf<>(
                vector
        ).equals(
                new IterableOf<>(
                        ((Stack<T>) obj).elements()
                )
        );
    }

    @Override
    public int hashCode() {
        return vector.hashCode();
    }

    /**
     * @return Format: Stack
     */
    @Override
    public String toString() {
        return "Stack: [" + new IterableOf<>(vector) + "]";
    }
}
