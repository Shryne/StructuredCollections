/**
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
package de.collections.iterable;

import de.collections.Collection;
import de.collections.list.base.ListOf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * A filter to iterate only through elements who fulfill the filter.
 */
public final class FilteredIterator<T> implements Iterator<T> {
    private final Collection<T> collection;
    private int cursor = -1;
    private final Predicate<T> filter;

    /**
     * Secondary constructor. Accepts all elements (no filter).
     * @param elements that are to be iterated through.
     */
    public FilteredIterator(T... elements) {
        this(new ListOf<>(elements));
    }

    /**
     * Secondary constructor. Accepts all elements (no filter).
     * @param collection which is to be iterated through.
     */
    public FilteredIterator(Collection<T> collection) {
        this(collection, element -> true);
    }

    /**
     * Primary constructor.
     * @param collection which is to be iterated through.
     * @param filter that accepts the elements and returns true if the element should be part of the iteration.
     */
    public FilteredIterator(Collection<T> collection, Predicate<T> filter) {
        this.collection = collection;
        this.filter = filter;
    }

    /**
     * @return true if there are elements left who fulfill the filter.
     */
    @Override
    public boolean hasNext() {
        while (cursor + 1 < collection.size()) {
            cursor++;
            if (filter.test(collection.get(cursor))) {
                cursor--;
                return true;
            }
        }
        return false;
    }

    /**
     * @return The next element that fulfills the filter.
     * @throws NoSuchElementException if there isn't any element left who fulfills the filter.
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(
                    String.format(
                            "The cursor (%d) needs to be smaller than the size of the iterable (%d)",
                            cursor, collection.size()
                    )
            );
        }
        cursor++;
        return collection.get(cursor);
    }

    /**
     * @return format: element1, element2, ...
     */
    @Override
    public String toString() {
        final var delimiter = ", ";
        if (!hasNext()) {
            return "";
        }
        final var result = new StringBuilder();
        while (hasNext()) {
            result
                    .append(next())
                    .append(delimiter);
        }
        cursor = -1;
        return result
                .replace(result.length() - delimiter.length(), result.length(), "")
                .toString();
    }
}
