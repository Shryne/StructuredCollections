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
package de.collections.iterable;


import de.collections.Collection;
import de.collections.functional.Lazy;
import de.collections.iterable.base.FilteredIterator;
import de.collections.iterable.base.IndexedIteratorEnvelope;

/**
 * An iterator that starts and ends on the specified indices.
 *
 * @param <T> The type of the elements of the iterator.
 */
public final class RangeOf<T> extends IndexedIteratorEnvelope<T> {
    /**
     * Secondary constructor for the full range (0 to collection.size() (exclusive)).
     *
     * @param collection that contains the elements.
     */
    public RangeOf(Collection<T> collection) {
        this(collection, 0);
    }

    /**
     * Secondary constructor. Ends with collection.size() (exclusive).
     *
     * @param collection that contains the elements.
     * @param from       range start (inclusive, greater or equal to 0, smaller than to).
     */
    public RangeOf(Collection<T> collection, int from) {
        this(collection, from, collection.size());
    }

    /**
     * Primary constructor.
     *
     * @param collection that contains the elements.
     * @param from       range start (inclusive, greater or equal to 0).
     * @param to         range end (exclusive).
     * @throws IllegalArgumentException if from or to are invalid.
     */
    public RangeOf(Collection<T> collection, int from, int to) {
        super(
                new Lazy<>(
                        () -> {
                            if (from < 0) {
                                throw new IllegalArgumentException("From needs to be greater than 0. From: " + from);
                            }
                            return new FilteredIterator<>(
                                    collection,
                                    (element, index) -> index <= from && index < Math.min(to, collection.size())
                            );
                        }
                )
        );
    }
}
