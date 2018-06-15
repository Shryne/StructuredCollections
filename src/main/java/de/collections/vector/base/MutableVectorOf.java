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
package de.collections.vector.base;

import de.collections.Collection;
import de.collections.array.IteratorAsArray;
import de.collections.array.base.MutableArray;
import de.collections.array.base.MutableArrayOf;
import de.collections.iterable.base.IterableOf;

import java.util.Iterator;

/**
 * A mutable vector implementation that grows in size but never shrinks.
 *
 * <p>This class is mutable and not thread safe.</p>
 *
 * @param <T> The type of the elements this vector can contain.
 */
public final class MutableVectorOf<T> implements MutableVector<T> {
    private static final double RESIZE_FACTOR = 1.5;
    private static final int MIN_SIZE = 10;

    private MutableArray<T> container;
    private int size;

    /**
     * @param collection that contains the elements for the vector.
     */
    public MutableVectorOf(Collection<T> collection) {
        this(new IterableOf<>(collection));
    }

    /**
     * @param iterable to create the iterator from that has the elements for the vector.
     */
    public MutableVectorOf(Iterable<T> iterable) {
        this(new IteratorAsArray<>(iterable.iterator()));
    }

    /**
     * @param iterator containing the elements for the vector.
     */
    public MutableVectorOf(Iterator<T> iterator) {
        this(new IteratorAsArray<>(iterator));
    }

    /**
     * @param elements the vector will contain.
     */
    @SafeVarargs
    public MutableVectorOf(T... elements) {
        this(new MutableArrayOf<>(elements));
    }

    /**
     * @param container that contains the elements for this vector.
     */
    public MutableVectorOf(MutableArray<T> container) {
        this.container = (container.size() < MIN_SIZE) ? container.resize(MIN_SIZE) : container;
        size = container.size();
    }

    @Override
    public T get(int index) {
        if (index < 0 || size <= index) {
            throw new IllegalArgumentException("The index has to be between 0 and size (exclusive) but is: " + index);
        }
        return container.get(index);
    }

    /**
     * Note that the size may differ from the internal capacity. The size of the vector is the index of the last set
     * element + 1.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, Iterable<T> iterable) {
        var iterator = iterable.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            if (container.size() <= index + i) {
                container = container.resize((int) (container.size() * RESIZE_FACTOR));
            }
            container.set(index + i, iterator.next());
            size = Math.max(size + 1, index + 1);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vector)) {
            return false;
        }
        //noinspection unchecked
        return new IterableOf<T>((Vector) obj)
                .equals(new IterableOf<>(this));
    }

    @Override
    public int hashCode() {
        return container.hashCode();
    }

    @Override
    public String toString() {
        return "Vector: [" + new IterableOf<>(this) + "]";
    }
}
