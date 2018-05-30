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
package de.collections.iterable;

/**
 * This interface wouldn't exist, if there would be an array interface in java => IterableAsArray.
 * @param <T> The type of the elements of the iterable.
 */
public interface ConvertibleIterable<T> extends Iterable<T> {
    /**
     * Creates a new array and puts the elements of the iterable inside of it.
     * @return The array with the elements.
     */
    default T[] asArray() {
        int size = 0;
        while (iterator().hasNext()) {
            size++;
        }

        @SuppressWarnings("unchecked")
        final T[] result = (T[]) new Object[size];

        int i = 0;
        for (T element : this) {
            result[i] = element;
            i++;
        }
        return result;
    }
}
