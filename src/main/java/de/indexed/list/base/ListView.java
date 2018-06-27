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
package de.indexed.list.base;

/**
 * A basic implementation of the list based on an array.
 * <p>This class is immutable and Thread-safe.</p>
 * @param <T> The type of the elements in the list.
 */
public final class ListView<T> implements List<T> {
    private final MutableList<T> mutableList;

    /**
     * Secondary constructor.
     * @param elements The elements that the list should contain.
     */
    @SafeVarargs
    public ListView(T... elements) {
        this(new VectorList<>(elements));
    }

    /**
     * Primary constructor.
     * @param mutableList that contains the elements. Based on the immutable list, this view will be created.
     */
    public ListView(MutableList<T> mutableList) {
        this.mutableList = mutableList;
    }

    /**
     * @throws IndexOutOfBoundsException If not (0 <= index or index < size).
     */
    @Override
    public T get(int index) {
        return mutableList.get(index);
    }

    @Override
    public int size() {
        return mutableList.size();
    }

    @Override
    public int hashCode() {
        return mutableList.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return mutableList.equals(obj);
    }

    /**
     * @return Format: List: [...]
     */
    @Override
    public String toString() {
        return mutableList.toString();
    }
}
