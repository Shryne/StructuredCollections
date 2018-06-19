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
package de.indexed.list.base;


import de.indexed.IndexedCollection;
import de.collections.iterable.base.IterableOf;
import de.collections.iterator.RangeOf;
import de.indexed.vector.ConcatVector;
import de.indexed.vector.IteratorAsMutableVector;
import de.indexed.vector.base.MutableVector;
import de.indexed.vector.base.MutableVectorOf;

import java.util.Iterator;

/**
 * Implementation of the mutable list.
 *
 * <p>This class is not thread safe.</p>
 *
 * @param <T> The type of the elements this list shall contain.
 */
public final class MutableListOf<T> implements MutableList<T> {
    private MutableVector<T> container;

    /**
     * @param iterator that has the elements for the list.
     */
    public MutableListOf(Iterator<T> iterator) {
        this(new IteratorAsMutableVector<>(iterator));
    }

    /**
     * @param elements the list shall contain.
     */
    public MutableListOf(T... elements) {
        this(new MutableVectorOf<>(elements));
    }

    /**
     * @param collection containing the elements for this list.
     */
    public MutableListOf(IndexedCollection<T> collection) {
        this(new MutableVectorOf<>(collection));
    }

    /**
     * @param mutableVector containing the elements for this list. If the user changes the list, the vector will be
     *                      changed, too.
     */
    public MutableListOf(MutableVector<T> mutableVector) {
        container = mutableVector;
    }

    /**
     * @throws IndexOutOfBoundsException If not (0 <= index or index < size).
     */
    @Override
    public T get(int index) {
        if (!(0 <= index || index < size())) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "Has to be between 0 (inclusive) and %s (exclusive), but is: %s",
                            size(), index
                    )
            );
        }
        return container.get(index);
    }

    @Override
    public int size() {
        return container.size();
    }

    @Override
    public void add(int index, T element) {
        container = new ConcatVector<>(
                new RangeOf<>(container, 0, index),
                element,
                new RangeOf<>(container, index + 1)
        );
    }

    @Override
    public void remove(int index) {
        if (size() <= index || index < 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "Index (%d) is greater than or equal to the size of the collection (%d) or smaller than" +
                                    " zero.",
                            index, size()
                    )
            );
        }
        container = new ConcatVector<>(
                new RangeOf<>(container, 0, index),
                new RangeOf<>(container, index + 1)
        );
    }

    /**
     * The list can only be equal to other lists.
     *
     * @see List
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return new IterableOf<>(
                (List<?>) obj
        ).equals(new IterableOf<>(this));
    }

    @Override
    public int hashCode() {
        return container.hashCode();
    }

    /**
     * @return Format: MutableList: [...]
     */
    @Override
    public String toString() {
        return "List: [" + new IterableOf<>(container) + "]";
    }
}
