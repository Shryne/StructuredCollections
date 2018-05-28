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
package de.collections.list.base;


import java.util.Arrays;

public final class MutableListOf<T> implements MutableList<T> {
    private final T[] container;

    /**
     * Primary constructor.
     * @param elements The elements that the list should contain. These elements will be copied, thus changes to the old
     *                 array don't affect the list. Note that changes on the elements will affect this list.
     */
    @SafeVarargs
    public MutableListOf(T... elements) {
        container = Arrays.copyOf(elements, elements.length);
    }

    /**
     * @throws IndexOutOfBoundsException If not (0 <= index or index < size).
     */
    @Override
    public T get(int index) {
        if (!(0 <= index || index < size())) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "Has to be between 0 (inclusive) and %s (exclusive), but is: %s",
                            size(), index
                    )
            );
        }
        return container[index];
    }

    @Override
    public int size() {
        return container.length;
    }


    @Override
    public void add(T element, int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * @return Format: MutableList: [...]
     */
    @Override
    public String toString() {
        return "MutableList: " + Arrays.toString(container);
    }
}
