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
package de.collections.list.base;

import de.collections.iterable.IterableOf;

import java.util.Arrays;

/**
 * A basic implementation of the list based on an array. This class is immutable.
 * @param <T> The type of the elements in the list.
 */
public final class ListOf<T> implements List<T> {
    private final MutableList<T> mutableList;

    /**
     * Secondary constructor.
     * @param elements The elements that the list should contain. These elements will be copied, thus changes to the old
     *                 array don't affect the list. Note that changes on the elements will affect this list.
     */
    @SafeVarargs
    public ListOf(T... elements) {
        this(
                new MutableListOf<>(
                        Arrays.copyOf(elements, elements.length)
                )
        );
    }

    public ListOf(MutableList<T> mutableList) {
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

    /**
     * @return Format: List: [...]
     */
    @Override
    public String toString() {
        return "List: [" + new IterableOf<>(mutableList) + "]";
    }
}
