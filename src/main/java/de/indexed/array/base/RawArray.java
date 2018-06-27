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

package de.indexed.array.base;

import de.collections.iterable.base.IterableOf;

import java.util.Arrays;

/**
 * Mutable array implementation.
 * @param <T> The type of the element inside the array.
 */
public final class RawArray<T> implements MutableArray<T> {
    private final T[] container;

    /**
     * @param elements the array shall contain.
     */
    @SafeVarargs
    public RawArray(T... elements) {
        container = elements;
    }

    @Override
    public MutableArray<T> resize(int size) {
        return new RawArray<>(
                Arrays.copyOf(container, size)
        );
    }

    @Override
    public T get(int index) {
        if (size() <= index || index < 0) {
            throw new IllegalArgumentException(
                    "The index must be lower than the size and positive. Index: " + index + ", size: " + size()
            );
        }
        return container[index];
    }

    @Override
    public void set(int index, Iterable<T> elements) {
        int i = 0;
        for (T element : elements) {
            if (size() <= index + i || index < 0) {
                throw new IllegalArgumentException(
                        "The index must be lower than the size and positive. Index: " + index + ", size: " + size()
                );
            }
            container[index + i] = element;
            i++;
        }
    }

    @Override
    public int size() {
        return container.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Array)) {
            return false;
        }
        //noinspection unchecked
        return new IterableOf<>(this).equals(
                new IterableOf<>((Array) obj)
        );
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(container);
    }

    @Override
    public String toString() {
        return "Array: " + Arrays.toString(container);
    }
}
