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

import java.util.Arrays;

/**
 * A mutable vector implementation that grows in size but never shrinks.
 *
 * <p>This class is mutable and not thread safe.</p>
 * @param <T> The type of the elements this vector can contain.
 */
public final class MutableVectorOf<T> implements MutableVector<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double CAPACITY_RAISE = 1.5; // will grow by 50 %

    private T[] elements;
    private int size;

    /**
     * Primary constructor.
     * @param elements the vactor will contain.
     */
    public MutableVectorOf(T... elements) {
        this.elements = elements;
        this.size = elements.length;
    }

    @Override
    public T get(int index) {
        if (!(0 <= index || index <= size())) {
            throw new IllegalArgumentException("The index has to be between 0 and size (exclusive) but is: " + index);
        }
        return elements[index];
    }

    /**
     * Note that the size may differ from the internal capacity. The size of the vector is the index of the last set
     * element + 1.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T element) {
        if (index > elements.length) {
            elements = Arrays.copyOf(
                    elements, (int) Math.max(elements.length * CAPACITY_RAISE, index)
            );
        }
        size = Math.max(size, index + 1);
        elements[index] = element;
    }
}
