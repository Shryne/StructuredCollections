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


import de.collections.iterable.IterableOf;
import de.collections.iterable.RangeOf;
import de.collections.vector.ConcatVector;
import de.collections.vector.MutableVector;
import de.collections.vector.MutableVectorOf;
import de.collections.vector.Vector;

import java.util.Arrays;

public final class MutableListOf<T> implements MutableList<T> {
    private MutableVector<T> container;

    public MutableListOf(T... elements) {
        this(new MutableVectorOf<>(elements));
    }

    public MutableListOf(Vector<T> vector) {
        this(new MutableVectorOf<>(vector));
    }

    /**
     * Primary constructor.
     * @param elements The elements that the list should contain. These elements will be copied, thus changes to the old
     *                 array don't affect the list. Note that changes on the elements will affect this list.
     */
    public MutableListOf(MutableVector<T> mutableVector) {
        container = mutableVector;
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
        return container.get(index);
    }

    @Override
    public int size() {
        return container.size();
    }


    @Override
    public void add(int index, T element) {
        container = new ConcatVector<>(
                new RangeOf<>(container, 0, index - 1),
                element,
                new RangeOf<>(container, index + 1)
        );
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
        return "MutableList: " + new IterableOf<>(container).toString();
    }
}
