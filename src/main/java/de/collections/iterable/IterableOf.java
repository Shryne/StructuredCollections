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

/**
 * The collection classes of the standard library implement an iterator internally,
 * but I think it should be the other way around to reduce the size of the classes.
 * @param <T> The element type of the elements in the iteration.
 */
public final class IterableOf<T> implements ConvertibleIterable<T> {
    private final Iterator<T> iterator;

    public IterableOf(T... elements) {
        this(new ListOf<>(elements));
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
     * @return format: [elements] (Unordered)
     */
    @Override
    public String toString() {
        return iterator.toString();
    }
}