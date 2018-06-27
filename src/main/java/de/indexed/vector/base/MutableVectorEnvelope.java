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
package de.indexed.vector.base;


import de.collections.functional.Lazy;

/**
 * An envelope for the MutableVector to get rid of the code duplication from the decorators.
 * @param <T> The type of the elements of the vector.
 */
public abstract class MutableVectorEnvelope<T> implements MutableVector<T> {
    private final Lazy<MutableVector<T>> lazyVector;

    /**
     * Primary constructor.
     * @param lazyVector that contains the functionality inside of Lazy.
     */
    public MutableVectorEnvelope(Lazy<MutableVector<T>> lazyVector) {
        this.lazyVector = lazyVector;
    }

    @Override
    public final T get(int index) {
        return lazyVector.value().get(index);
    }

    @Override
    public final void set(int index, Iterable<T> elements) {
        lazyVector.value().set(index, elements);
    }

    @Override
    public final int size() {
        return lazyVector.value().size();
    }

    @Override
    public final void shrink(int newSize) {
        lazyVector.value().shrink(newSize);
    }

    @Override
    public boolean equals(Object obj) {
        return lazyVector.value().equals(obj);
    }

    @Override
    public int hashCode() {
        return lazyVector.value().hashCode();
    }

    @Override
    public String toString() {
        return lazyVector.value().toString();
    }
}
