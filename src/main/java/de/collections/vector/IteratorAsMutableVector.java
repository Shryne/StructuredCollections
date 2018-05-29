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
package de.collections.vector;

import de.collections.functional.Lazy;
import de.collections.iterable.ConvertibleIterable;

import java.util.Iterator;

public final class IteratorAsMutableVector<T> implements MutableVector<T> {
    private final Lazy<MutableVector<T>> lazyMutableVector;

    public IteratorAsMutableVector(Iterable<T> iterable) {
        this(iterable.iterator());
    }

    public IteratorAsMutableVector(Iterator<T> iterator) {
        lazyMutableVector = new Lazy<>(
                () -> {
                    @SuppressWarnings("unchecked")
                    final var vector = new MutableVectorOf<T>();
                    while (iterator.hasNext()){
                        vector.set(vector.size(), iterator.next());
                    }
                    return vector;
                }
        );
    }


    @Override
    public T get(int index) {
        return lazyMutableVector.value().get(index);
    }

    @Override
    public void set(int index, ConvertibleIterable<T> elements) {
        lazyMutableVector.value().set(index, elements);
    }

    @Override
    public int size() {
        return lazyMutableVector.value().size();
    }
}
