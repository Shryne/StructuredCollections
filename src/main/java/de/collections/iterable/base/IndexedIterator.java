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

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implementation of the {@link ListIterator} interface.
 *
 * <p>This class is mutable and not thread-safe.</p>
 * @param <T> The type of the elements of the iterator.
 */
public final class IndexedIterator<T> implements ListIterator<T> {
    private final Collection<T> collection;
    private int cursor = -1;

    /**
     * Primary constructor.
     * @param collection that will be iterated.
     */
    public IndexedIterator(Collection<T> collection) {
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
    public boolean hasPrevious() {
        return cursor > 0;
    }

    @Override
    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException(
                    String.format(
                            "The cursor (%d) needs to be greater than zero.",
                            cursor
                    )
            );
        }
        final var result = collection.get(cursor);
        cursor--;
        return result;
    }

    @Override
    public int nextIndex() {
        // TODO: What if there isn't any next index?
        return cursor + 1;
    }

    @Override
    public int previousIndex() {
        return cursor;
    }

    // TODO: Write my own list iterator?
    @Override
    public void remove() {
        throw new UnsupportedOperationException("This iterator doesn't remove elements.");
    }

    @Override
    public void set(T t) {
        throw new UnsupportedOperationException("This iterator doesn't set elements.");
    }

    @Override
    public void add(T t) {
        throw new UnsupportedOperationException("This iterator doesn't add elements.");
    }
}
