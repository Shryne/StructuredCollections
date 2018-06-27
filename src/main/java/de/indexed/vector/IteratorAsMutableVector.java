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
package de.indexed.vector;

import de.collections.functional.Lazy;
import de.indexed.vector.base.MutableVectorEnvelope;
import de.indexed.vector.base.ArrayVector;

import java.util.Iterator;

/**
 * A conversion from an iterator to a mutable vector. The elements will be taken once from the iterator and this
 * operation will mutate the iterator.
 *
 * This class is mutable and not thread-safe.
 * @see Iterator#next()
 * @param <T> The type of the elements of the iterator (and thus of the vector).
 */
public final class IteratorAsMutableVector<T> extends MutableVectorEnvelope<T> {
    /**
     * Secondary constructor.
     * @param iterable that offers the iterator.
     */
    public IteratorAsMutableVector(Iterable<T> iterable) {
        this(iterable.iterator());
    }

    /**
     * Primary constructor.
     * @param iterator that will be converted to the vector.
     */
    public IteratorAsMutableVector(Iterator<T> iterator) {
        super(
                new Lazy<>(
                        () -> {
                            @SuppressWarnings("unchecked") final var vector = new ArrayVector<T>();
                            while (iterator.hasNext()) {
                                vector.set(vector.size(), iterator.next());
                            }
                            return vector;
                        }
                )
        );
    }
}
