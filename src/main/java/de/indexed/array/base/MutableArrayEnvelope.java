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

package de.indexed.array.base;

import de.collections.functional.Lazy;

/**
 * A class to get rid of the code duplication that occurs using the decorator pattern.
 * @param <T> The type of the elements of the array.
 */
public abstract class MutableArrayEnvelope<T> extends ArrayEnvelope<T> implements MutableArray<T> {
    private final Lazy<MutableArray<T>> lazyArray;

    /**
     * Primary constructor.
     * @param lazyArray that has the functionality for this class.
     */
    public MutableArrayEnvelope(Lazy<MutableArray<T>> lazyArray) {
        super(lazyArray);
        this.lazyArray = lazyArray;
    }

    @Override
    public final void set(int index, Iterable<T> elements) {
        lazyArray.value().set(index, elements);
    }

    @Override
    public MutableArray<T> resize(int size) {
        return lazyArray.value().resize(size);
    }
}
