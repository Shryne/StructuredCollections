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

package de.indexed;

import de.collections.iterable.base.IterableOf;
import de.indexed.array.base.ArrayOf;

/**
 * Defines a range of an indexed collection.
 * <p>This class is immutable and thread-safe.</p>
 * @param <T> The type of the elements.
 */
public final class Range<T> implements IndexedCollection<T> {
    private final IndexedCollection<T> collection;
    private final int from;
    private final int to;

    /**
     * @param from The start of the range. If from is smaller than 0, 0 will be taken instead. (inclusive)
     * @param to The end of the range. Collection.size - 1 will be taken, if to is greater or equal to size. (exclusive)
     * @param ts the array with the elements.
     */
    public Range(int from, int to, T... ts) {
        this(
                new ArrayOf<>(ts),
                from,
                to
        );
    }

    /**
     * Takes the collection.size as "to".
     * @param collection The collection that contains the elements.
     * @param from The start of the range. If from is smaller than 0, 0 will be taken instead. (inclusive)
     */
    public Range(IndexedCollection<T> collection, int from) {
        this(
                collection,
                from,
                collection.size()
        );
    }

    /**
     * @param collection The collection that contains the elements.
     * @param from The start of the range. If from is smaller than 0, 0 will be taken instead. (inclusive)
     * @param to The end of the range. Collection.size - 1 will be taken, if to is greater or equal to size. (exclusive)
     */
    public Range(IndexedCollection<T> collection, int from, int to) {
        this.collection = collection;
        this.from = Math.max(0, from);
        this.to = Math.min(to, collection.size());
    }

    /**
     * @return The size of the collection with regards to the start and the end of the range. The minimal size of the
     * range is 0.
     */
    @Override
    public int size() {
        return Math.max(to - from, 0);
    }

    @Override
    public T get(int index) {
        if (to <= from + index) {
            throw new IllegalArgumentException(
                    String.format(
                            "Index + from must be smaller than to. From: %d, to: %d, index: %d.",
                            from, to, index
                    )
            );
        }
        return collection.get(from + index);
    }

    @Override
    public String toString() {
        return String.format(
                "%s: [%s]",
                getClass().getSimpleName(),
                new IterableOf<>(
                        this
                ).toString()
        );
    }
}
