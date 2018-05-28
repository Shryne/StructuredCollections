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

/**
 * An implementation of the vector interface. Uses an array as its base.
 *
 * <p>This class is immutable.</p>
 * @param <T> The type of the elements this vector can contain.
 */
public final class VectorOf<T> implements Vector<T> {
    private final T[] elements;

    /**
     * Primary constructor.
     * @param elements the vactor will contain.
     */
    public VectorOf(T... elements) {
        this.elements = elements;
    }

    @Override
    public T get(int index) {
        if (!(0 <= index || index <= size())) {
            throw new IllegalArgumentException("The index has to be between 0 and size (exclusive) but is: " + index);
        }
        return elements[index];
    }

    @Override
    public int size() {
        return elements.length;
    }
}
