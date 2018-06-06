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

import de.collections.functional.Lazy;

/**
 * The envelope of the {@link IndexedIterator} interface.
 * @param <T> The type of the elements of the iterator.
 */
public abstract class IndexedIteratorEnvelope<T> implements IndexedIterator<T> {
    private final Lazy<? extends IndexedIterator<T>> lazyIterator;

    /**
     * @param lazyIterator that contains the iterator with the functionality inside a Lazy.
     */
    public IndexedIteratorEnvelope(Lazy<? extends IndexedIterator<T>> lazyIterator) {
        this.lazyIterator = lazyIterator;
    }

    @Override
    public final int nextIndex() {
        return lazyIterator.value().nextIndex();
    }

    @Override
    public final boolean hasNext() {
        return lazyIterator.value().hasNext();
    }

    @Override
    public final T next() {
        return lazyIterator.value().next();
    }

    @Override
    public boolean equals(Object obj) {
        return lazyIterator.value().equals(obj);
    }

    @Override
    public int hashCode() {
        return lazyIterator.value().hashCode();
    }

    @Override
    public String toString() {
        return lazyIterator.value().toString();
    }
}
