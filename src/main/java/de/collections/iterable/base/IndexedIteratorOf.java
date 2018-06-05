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

package de.collections.iterable.base;

import de.collections.Collection;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implementation of the {@link ListIterator} interface.
 *
 * <p>This class is mutable and not thread-safe.</p>
 * @param <T> The type of the elements of the iterator.
 */
public final class IndexedIteratorOf<T> implements IndexedIterator<T> {
    private final Collection<T> collection;
    private int cursor = -1;

    /**
     * Primary constructor.
     * @param collection that will be iterated.
     */
    public IndexedIteratorOf(Collection<T> collection) {
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

    /**
     * It can only be equal with another iterable.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Iterator)) {
            return false;
        }
        final Iterator<?> other = ((Iterator<?>) obj);
        

        for (T element : this) {
            if (!other.hasNext() || !Objects.equals(element, other.next())) {
                return false;
            }
        }
        return !other.hasNext();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (T t : this) {
            hashCode = 31 * hashCode + Objects.hashCode(t);
        }
        return hashCode;
    }

    /**
     * @return format: [elements] (Unordered)
     */
    @Override
    public String toString() {
        return iterator().toString();
    }
}
