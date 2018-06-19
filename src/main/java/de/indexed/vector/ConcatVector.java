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
import de.collections.iterable.ConcatIterable;
import de.indexed.vector.base.MutableVector;
import de.indexed.vector.base.MutableVectorEnvelope;
import de.indexed.vector.base.MutableVectorOf;
import de.indexed.vector.base.Vector;

import java.util.Iterator;

/**
 * Combines vectors to one.
 * @param <T> The type of the elements of the vectors.
 */
public final class ConcatVector<T> extends MutableVectorEnvelope<T> {
    /**
     * Secondary constructor.
     * @param front part of the iterator.
     * @param middle part of the iterator.
     * @param back part of the iterator.
     */
    public ConcatVector(Iterator<T> front, T middle, Iterator<T> back) {
        this(
                new MutableVectorOf<>(front),
                middle,
                new MutableVectorOf<>(back)
        );
    }

    /**
     * Secondary constructor.
     * @param front part of the iterator.
     * @param back part of the iterator.
     */
    public ConcatVector(Vector<T> front, Vector<T> back) {
        this(
                new MutableVectorOf<>(front),
                new MutableVectorOf<>(back)
        );
    }

    /**
     * Secondary constructor.
     * @param front part of the iterator.
     * @param middle part of the iterator.
     * @param back part of the iterator.
     */
    public ConcatVector(MutableVector<T> front, T middle, MutableVector<T> back) {
        //noinspection unchecked
        this(
                new ConcatVector<>(
                        front,
                        new MutableVectorOf<>(middle)
                ),
                back
        );
    }

    /**
     * Secondary constructor.
     * @param first part of the iterator.
     * @param second part of the iterator.
     */
    public ConcatVector(Iterator<T> first, Iterator<T> second) {
        this(
                new MutableVectorOf<>(first),
                new MutableVectorOf<>(second)
        );
    }

    /**
     * Primary constructor.
     * @param first part of the vector.
     * @param second part of the vector.
     */
    public ConcatVector(MutableVector<T> first, MutableVector<T> second) {
        super(
                new Lazy<>(
                        () -> {
                            //noinspection unchecked
                            final var vector = new MutableVectorOf<T>();
                            for (T element : new ConcatIterable<>(first, second)) {
                                vector.set(vector.size(), element);
                            }
                            return vector;
                        }
                )
        );
    }
}
