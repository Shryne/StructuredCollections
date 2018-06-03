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
package de.collections.array;

import de.collections.array.base.Array;
import de.collections.array.base.MutableArrayEnvelope;
import de.collections.array.base.MutableArrayOf;
import de.collections.functional.Lazy;
import de.collections.iterable.ConcatIterable;

/**
 * Represents the concatenation of arrays.
 * @param <T> The type of the elements inside the array.
 */
public class ConcatArray<T> extends MutableArrayEnvelope<T> {
    /**
     * Primary constructor.
     * @param first part of the array.
     * @param second part of the array.
     */
    public ConcatArray(Array<T> first, Array<T> second) {
        super(
                new Lazy<>(
                        () -> {
                            //noinspection unchecked
                            var result = new MutableArrayOf<T>().resize(first.size() + second.size());
                            result.set(0, new ConcatIterable<>(first, second));
                            return result;
                        }
                )
        );
    }
}
