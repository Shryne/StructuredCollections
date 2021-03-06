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


import de.collections.indexed.IndexedCollection;
import de.collections.iterable.base.IndexedIterable;
import de.collections.iterator.ConcatIterator;
import de.collections.iterator.base.IndexedIterator;
import de.collections.iterable.base.IterableOf;

/**
 * Combines iterables to one.
 * @param <T> The type of the elements inside of the iterables.
 */
public final class ConcatIterable<T> implements IndexedIterable<T> {
    private final IndexedIterable<T> first;
    private final IndexedIterable<T> second;

    /**
     * Secondary constructor;
     * @param first part of the iterable.
     * @param second part of the iterable.
     */
    public ConcatIterable(IndexedCollection<T> first, IndexedCollection<T> second) {
        this(
                new IterableOf<>(first),
                new IterableOf<>(second)
        );
    }

    /**
     * Primary constructor.
     * @param first part of the iterable.
     * @param second part of the iterable.
     */
    public ConcatIterable(IndexedIterable<T> first, IndexedIterable<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public IndexedIterator<T> indexedIterator() {
        return new ConcatIterator<>(
                first.indexedIterator(),
                second.indexedIterator()
        );
    }
}
