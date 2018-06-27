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
package de.collections.iterator;


import de.collections.indexed.IndexedCollection;
import de.collections.iterator.base.IndexedIterator;

import java.util.NoSuchElementException;

/**
 * An iterator that starts and ends on the specified indices.
 * <p>This class is mutable and not thread-safe.</p>
 * @param <T> The type of the elements of the iterator.
 */
public final class RangeOf<T> implements IndexedIterator<T> {
    private final IndexedCollection<T> collection;
    private int cursor;
    private final int to;

    /**
     * Secondary constructor for the full range (0 to collection.size() (exclusive)).
     *
     * @param collection that contains the elements.
     */
    public RangeOf(IndexedCollection<T> collection) {
        this(collection, 0);
    }

    /**
     * Secondary constructor. Ends with collection.size() (exclusive).
     *
     * @param collection that contains the elements.
     * @param from       range start (inclusive, greater or equal to 0, smaller than to).
     */
    public RangeOf(IndexedCollection<T> collection, int from) {
        this(collection, from, collection.size());
    }

    /**
     * Primary constructor.
     *
     * @param collection that contains the elements.
     * @param from       range start (inclusive).
     * @param to         range end (exclusive). If range is greater than collection.size(), collection.size() will be
     *                   taken as the end of the range instead.
     * @throws IllegalArgumentException if from is invalid.
     */
    public RangeOf(IndexedCollection<T> collection, int from, int to) {
        cursor = Math.max(from - 1, -1);
        this.to = Math.min(collection.size(), to);
        this.collection = collection;
    }


    @Override
    public int nextIndex() {
        return cursor + 1;
    }

    @Override
    public boolean hasNext() {
        return cursor + 1 < to;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no elements left");
        }
        cursor++;
        return collection.get(cursor);
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("Can't compare without altering the state.");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Can't calculate the hash without altering the state.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Can't create the string without altering the state.");
    }
}
