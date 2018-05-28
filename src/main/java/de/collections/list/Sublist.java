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
package de.collections.list;

import de.collections.list.base.List;

/**
 * Defines a view on a given area that can be equal to the origin data structure. This class is immutable.
 * @param <T> The type of the contained elements.
 */
public final class Sublist<T> implements List<T> {
    private final List<T> list;
    private final int start;
    private final int end;

    /**
     * Primary constructor.
     * @param list to create the sublist from.
     * @param start index (inclusive).
     * @param end index (exclusive).
     * @throws IllegalArgumentException if:
     * <li>start >= end</li>
     * <li>start < 0</li>
     * <li>end < 0</li>
     * <li>start >= list.size()</li>
     * <li>end >= list.size()</li>
     */
    public Sublist(List<T> list, int start, int end) {
        if (between(start, 0, list.size()) && between(end, 0, list.size())) {
            throw new IllegalArgumentException(
                    String.format(
                            "The start and the end need to be between 0 and list.size(). " +
                                    "List.size(): %d, start: %d, end: %d",
                            list.size(), start, end
                    )
            );
        }
        if (start >= end) {
            throw new IllegalArgumentException(
                    "The start needs to be smaller than the end. Start: " + start + ", end: " + end
            );
        }
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    public T get(int index) {
        return list.get(start + index);
    }

    @Override
    public int size() {
        return end - start;
    }

    private static boolean between(int elem, int min, int max) {
        return min <= elem && elem < max;
    }

    /**
     * @return format: Sublist: [...]
     */
    @Override
    public String toString() {
        return "Sublist: ["; // TODO: Complete it and implement some classes to make it easy
    }
}
