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
package de.collections.vector;

import de.collections.functional.Lazy;
import de.collections.iterable.ConvertibleIterator;
import de.collections.iterable.IterableOf;
import de.collections.vector.base.MutableVector;
import de.collections.vector.base.MutableVectorEnvelope;
import de.collections.vector.base.MutableVectorOf;


public final class ConcatVector<T> extends MutableVectorEnvelope<T> {
    public ConcatVector(ConvertibleIterator<T> front, T middle, ConvertibleIterator<T> back) {
        this(
                new MutableVectorOf<>(front),
                middle,
                new MutableVectorOf<>(back)
        );
    }

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

    public ConcatVector(ConvertibleIterator<T> first, ConvertibleIterator<T> second) {
        this(
                new MutableVectorOf<>(first),
                new MutableVectorOf<>(second)
        );
    }

    public ConcatVector(MutableVector<T> first, MutableVector<T> second) {
        super(
                new Lazy<>(
                        () -> {
                            for (T element : new IterableOf<>(second)) {
                                first.set(first.size(), element);
                            }
                            return first;
                        }
                )
        );
    }
}
