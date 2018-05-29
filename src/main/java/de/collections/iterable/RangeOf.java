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

import java.util.Iterator;

public final class RangeOf<T> implements Iterator<T> {
    private final Collection<T> collection;
    private final int from;
    private final int to;

    private int cursor = -1;

    public RangeOf(Collection<T> collection, int from) {
        this(collection, from, collection.size());
    }

    /**
     * Primary constructor.
     * @param collection that contains the elements.
     * @param from range start (inclusive, greater or equal to 0, smaller than to).
     * @param to range end (exclusive, greater than 0 and from, smaller or equal to collection.size()).
     * @throws IllegalArgumentException if from or to are invalid.
     */
    public RangeOf(Collection<T> collection, int from, int to) {
        if (!(0 <= from && from <= to) || !(0 < to && to <= collection.size())) {
            throw new IllegalArgumentException(
                    String.format(
                            "From needs to be between 0 and to, to needs to be greater than 0 and smaller or equal to" +
                                    "the size of the collection. From: %d, to: %d, collection.size(): %d",
                            from, to, collection.size()
                    )
            );
        }
        this.collection = collection;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean hasNext() {
        return cursor + 1 < to; // TODO: What if someone changes the bounds of the collection from outside?
    }

    @Override
    public T next() {
        // TODO: hasNext check
        cursor++;
        return collection.get(cursor);
    }
}
