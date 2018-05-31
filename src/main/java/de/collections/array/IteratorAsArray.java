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

import de.collections.array.base.*;
import de.collections.functional.Lazy;

import java.util.Iterator;

/**
 * An iterator that is converted to an array. Note that the operation of constructing the array will probably involve
 * some resizing of the underlying array, because an iterator doesn't know his size.
 * @param <T> The type of the elements inside the iterator and array.
 */
public final class IteratorAsArray<T> extends ArrayEnvelope<T> {
    private static final double GROWTH_FACTOR = 1.5;

    /**
     * Primary constructor.
     * @param iterator containing the elements.
     */
    public IteratorAsArray(Iterator<T> iterator) {
        super(
                new Lazy<>(
                        () -> {
                            //noinspection unchecked
                            MutableArray<T> result = new MutableArrayOf<>();
                            int cursor = -1;
                            while (iterator.hasNext()) {
                                if (cursor + 1 == result.size()) {
                                    //noinspection unchecked
                                    result = result.resize((int) (result.size() * GROWTH_FACTOR));
                                }
                                cursor++;
                                result.set(cursor, iterator.next());
                            }
                            return result.resize(cursor);
                        }
                )
        );
    }
}
