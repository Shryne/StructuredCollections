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
package de.collections.indexed.array.base;

/**
 * Implementation of the array.
 * <p>This class is mutable and not thread-safe.</p>
 * @param <T> The type of the elements inside the array.
 */
public final class ArrayView<T> implements Array<T> {
    private MutableArray<T> mutableArray;

    /**
     * Secondary constructor.
     * @param elements the array shall contain.
     */
    public ArrayView(T... elements) {
        this(new RawArray<>(elements));
    }

    /**
     * Primary constructor.
     * @param mutableArray upon which this view is based on.
     */
    public ArrayView(MutableArray<T> mutableArray) {
        this.mutableArray = mutableArray;
    }


    @Override
    public T get(int index) {
        //noinspection unchecked
        return mutableArray.get(index);
    }

    @Override
    public int size() {
        return mutableArray.size();
    }

    /**
     * An array is only equal to other arrays.
     * @see Array
     */
    @Override
    public boolean equals(Object obj) {
        return mutableArray.equals(obj);
    }

    @Override
    public int hashCode() {
        return mutableArray.hashCode();
    }

    /**
     * @return Format: Array: [elements]
     */
    @Override
    public String toString() {
        return mutableArray.toString();
    }
}
