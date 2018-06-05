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

import de.collections.iterable.base.IndexedIterator;

/**
 * Combines iterators to one.
 * <p>This class is mutable and not thread-safe.</p>
 * @param <T> The type of the elements inside of the iterator.
 */
public final class ConcatIterator<T> implements IndexedIterator<T> {
    private final IndexedIterator<T> first;
    private final IndexedIterator<T> second;

    /**
     * Primary constructor.
     * @param first part of the iterator.
     * @param second part of the iterator.
     */
    public ConcatIterator(IndexedIterator<T> first, IndexedIterator<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean hasNext() {
        return first.hasNext() || second.hasNext();
    }

    @Override
    public T next() {
        if (first.hasNext()) {
            return first.next();
        }
        return second.next();
    }

    @Override
    public int nextIndex() {
        return first.nextIndex() + second.nextIndex();
    }
}
