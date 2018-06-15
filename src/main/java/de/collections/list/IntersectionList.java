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

package de.collections.list;

import de.collections.Collection;
import de.collections.ContainsLinear;
import de.collections.functional.Lazy;
import de.collections.iterator.FilteredIterator;
import de.collections.list.base.MutableListEnvelope;
import de.collections.list.base.MutableListOf;

/**
 * An intersection as a list. This means it will only contain the elements that are inside all of the given collections.
 * @param <T> The type of the elements inside the list.
 */
public final class IntersectionList<T> extends MutableListEnvelope<T> {
    /**
     * @param first collection.
     * @param second collection.
     */
    public IntersectionList(Collection<T> first, Collection<T> second) {
        super(
                new Lazy<>(
                        () ->
                            new MutableListOf<>(
                                    new FilteredIterator<>(
                                            first,
                                            (e, i) ->
                                                    new ContainsLinear<>(
                                                            second, e
                                                    ).value()
                                    )
                            )
                )
        );
    }
}