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
import de.collections.iterable.ConvertibleIterable;
import de.collections.iterable.IterableOf;

import java.util.Iterator;

public final class ConcatVector<T> implements MutableVector<T> {
    private final Lazy<MutableVector<T>> lazyVector;


    public ConcatVector(Iterator<T> front, T middle, Iterator<T> back) {
        this(
                new IteratorAsMutableVector<>(front),
                middle,
                new IteratorAsMutableVector<>(back)
        );
    }

    public ConcatVector(MutableVector<T> front, T middle, MutableVector<T> back) {
        lazyVector = new Lazy<>(
                () -> {
                    front.set(front.size(), middle);
                    for (T element : new IterableOf<>(back)) {
                        front.set(front.size(), element);
                    }
                    return front;
                }
        );
    }

    @Override
    public T get(int index) {
        return lazyVector.value().get(index);
    }

    @Override
    public void set(int index, ConvertibleIterable<T> elements) {
        lazyVector.value().set(index, elements);
    }

    @Override
    public int size() {
        return lazyVector.value().size();
    }
}
