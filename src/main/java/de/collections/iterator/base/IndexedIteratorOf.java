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

package de.collections.iterator.base;

import de.indexed.IndexedCollection;
import de.indexed.list.base.ListOf;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implementation of the {@link ListIterator} interface.
 *
 * <p>This class is mutable and not thread-safe.</p>
 * @param <T> The type of the elements of the iterator.
 */
public final class IndexedIteratorOf<T> implements IndexedIterator<T> {
    private final IndexedCollection<T> collection;
    private int cursor = -1;

    public IndexedIteratorOf(T... ts) {
        this(new ListOf<>(ts));
    }

    /**
     * @param collection that will be iterated.
     */
    public IndexedIteratorOf(IndexedCollection<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return cursor + 1 < collection.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(
                    String.format(
                        "The cursor (%d) needs to be smaller than the size of the collection (%d).",
                            cursor, collection.size()
                    )
            );
        }
        cursor++;
        return collection.get(cursor);
    }

    @Override
    public int nextIndex() {
        return cursor + 1;
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("Can't compare iterators without altering them.");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Can't calculate hashCode without altering the iterator.");
    }

    /**
     * @return format: [elements] (Unordered)
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Can't transform to string without altering the iterator.");
    }
}
