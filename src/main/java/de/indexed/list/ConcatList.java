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
package de.indexed.list;

import de.collections.functional.Lazy;
import de.collections.iterable.ConcatIterable;
import de.indexed.list.base.List;
import de.indexed.list.base.MutableListEnvelope;
import de.indexed.list.base.MutableListOf;

/**
 * A concatenation of two lists. This object doesn't really concatenate lists. Instead it gives a view over the two
 * lists as if it were one.
 *
 * @param <T> The element type of the list.
 */
public final class ConcatList<T> extends MutableListEnvelope<T> {
    /**
     * Primary constructor.
     *
     * @param first  list.
     * @param second list.
     */
    public ConcatList(List<T> first, List<T> second) {
        super(
                new Lazy<>(
                        () -> {
                            //noinspection unchecked
                            final var list = new MutableListOf<T>();
                            for (T element : new ConcatIterable<>(first, second)) {
                                list.add(element);
                            }
                            return list;
                        }
                )
        );
    }
}
