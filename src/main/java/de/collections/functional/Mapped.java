/*
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

package de.collections.functional;

import de.collections.Collection;
import de.indexed.array.base.Array;
import de.indexed.array.base.MutableArrayOf;

import java.util.function.Function;

/**
 * Maps the results to an array.
 * @param <T> The type of the elements.
 */
public final class Mapped<T> {
    private final Collection<T> collection;

    /**
     * @param collection that offers the elements for the results that will be mapped.
     */
    public Mapped(Collection<T> collection) {
        this.collection = collection;
    }

    /**
     * Applies the given function on each element of the collection and mapps the result into an array.
     * @param function to apply.
     * @param <R> The type of the elements inside the resulting array.
     * @return The array with the mapped elements.
     */
    public <R> Array<R> apply(Function<T, R> function) {
        final var array = new MutableArrayOf<R>().resize(collection.size());
        for (int i = 0; i < collection.size(); i++) {
            array.set(i, function.apply(collection.get(i)));
        }
        return array;
    }
}
