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
package de.collections.iterable.base;

import de.collections.Collection;
import de.collections.iterator.base.IndexedIterator;
import de.collections.iterator.base.IndexedIteratorOf;
import de.collections.list.base.ListOf;

import java.util.Iterator;
import java.util.Objects;

/**
 * The collection classes of the standard library implement an iterator internally,
 * but I think it should be the other way around to reduce the size of the classes.
 * @param <T> The element type of the elements in the iteration.
 */
public final class IterableOf<T> implements IndexedIterable<T> {
    private final Collection<T> collection;

    /**
     * @param elements to iterate through.
     */
    public IterableOf(T... elements) {
        this(new ListOf<>(elements));
    }

    /**
     * @param collection to iterate through.
     */
    public IterableOf(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public IndexedIterator<T> indexedIterator() {
        return new IndexedIteratorOf<>(collection);
    }

    /**
     * It can only be equal with another iterable.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Iterable)) {
            return false;
        }
        final Iterator<?> other = ((Iterable<?>) obj).iterator();
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
        final var delimiter = ", ";
        final var iterator = iterator();
        if (!iterator.hasNext()) {
            return "";
        }
        final var result = new StringBuilder();
        while (iterator.hasNext()) {
            result
                    .append(iterator.next())
                    .append(delimiter);
        }
        return result
                .replace(result.length() - delimiter.length(), result.length(), "")
                .toString();
    }
}
