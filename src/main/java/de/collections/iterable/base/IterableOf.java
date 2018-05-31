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
import de.collections.list.base.ListOf;

import java.util.Iterator;
import java.util.Objects;

/**
 * The collection classes of the standard library implement an iterator internally,
 * but I think it should be the other way around to reduce the size of the classes.
 * @param <T> The element type of the elements in the iteration.
 */
public final class IterableOf<T> implements Iterable<T> {
    private final Iterator<T> iterator;

    /**
     * Secondary constructor.
     * @param elements to iterate through.
     */
    public IterableOf(T... elements) {
        this(new FilteredIterator<>(elements));
    }

    /**
     * Secondary constructor.
     * @param collection to iterate through.
     */
    public IterableOf(Collection<T> collection) {
        this(new FilteredIterator<>(collection));
    }

    /**
     * Primary constructor.
     * @param iterator for the iteration.
     */
    public IterableOf(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<T> iterator() {
        new ListOf<>(1);
        return iterator;
    }

    /**
     * It can only be equal with another iterable.
     * @param obj to be compared with.
     * @return whether the objects are equal or not.
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
        return iterator().toString();
    }
}
